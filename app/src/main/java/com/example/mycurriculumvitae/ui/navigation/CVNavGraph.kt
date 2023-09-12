package com.example.mycurriculumvitae.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycurriculumvitae.ui.screens.EditScreen
import com.example.mycurriculumvitae.ui.screens.HomeScreen


enum class CVScreen() {
    HomeScreen,
    EditScreen
}
@Composable
fun CVNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = CVScreen.HomeScreen.name,
        modifier = Modifier.padding(4.dp)
    ) {
        composable(route = CVScreen.HomeScreen.name) {
            HomeScreen(
                navigateToEditScreen = {navController.navigate(CVScreen.EditScreen.name)}
            )
        }
        composable(route = CVScreen.EditScreen.name) {
            EditScreen(
                navigateToHomeScreen = {
                    navController.navigate(CVScreen.HomeScreen.name)
                }
            )
        }
    }
}