package com.example.mycurriculumvitae.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycurriculumvitae.R
import com.example.mycurriculumvitae.model.CVUiState
import com.example.mycurriculumvitae.ui.screens.CvViewModel
import com.example.mycurriculumvitae.ui.screens.EditScreen
import com.example.mycurriculumvitae.ui.screens.HomeScreen


enum class CVScreen(@StringRes val title: Int) {
    HomeScreen(title = R.string.app_name),
    EditScreen(title = R.string.edit_screen)
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CVAppBar(
    currentScreen: CVScreen,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit
) {
    TopAppBar(
        title = { Text(text = stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        }

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CVNavHost(
    cvViewModel: CvViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    onEditButtonClicked: () -> Unit
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CVScreen.valueOf(
        backStackEntry?.destination?.route ?: CVScreen.HomeScreen.name
    )

    Scaffold(
        topBar = {
            CVAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        floatingActionButton = {
            if (currentScreen == CVScreen.HomeScreen) {
                FloatingActionButton(
                    onClick = onEditButtonClicked,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Create,
                        contentDescription = stringResource(R.string.edit_float_action_button)
                    )
                }
            }
        },
    )
    { innerPadding ->
        val uiState by cvViewModel.uiState.collectAsState()
        //declaration of the navHost
        NavHost(
            navController = navController,
            startDestination = CVScreen.HomeScreen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = CVScreen.HomeScreen.name) {
                HomeScreen(
                    onEditButtonClicked = {
                        navController.navigate(CVScreen.EditScreen.name)
                    }
                )
            }
            composable(route = CVScreen.EditScreen.name) {
                EditScreen(
                    onSaveButtonClicked = {
                        navController.popBackStack(CVScreen.HomeScreen.name, inclusive = false)
                    }
                )
            }
        }
    }
}
