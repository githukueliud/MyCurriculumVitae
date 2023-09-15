package com.example.mycurriculumvitae.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycurriculumvitae.model.CVUiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    onSaveButtonClicked: () -> Unit,
    cvViewModel: CvViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by cvViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditPersonalInfo(
            cvViewModel = cvViewModel,
            currentName = uiState.currentName,
            currentGithubHandle = uiState.currentGithubHandle,
            currentPhoneNumber = uiState.currentPhoneNumber,
            currentSummaryText = uiState.currentSummaryText,
            currentSlackName = uiState.currentSlackName,
            modifier = modifier
        )
        Button(
            onClick = {
                val updatedInfo = CVUiState(
                    currentName = uiState.currentName,
                    currentGithubHandle = uiState.currentGithubHandle,
                    currentPhoneNumber = uiState.currentPhoneNumber,
                    currentSummaryText = uiState.currentSummaryText,
                    currentSlackName = uiState.currentSlackName,
                )
                // Save the edited info by calling the view model function
                cvViewModel.updateCvDetails(updatedInfo)
                onSaveButtonClicked()
            }
        ) {
            Text(text = "Save")
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPersonalInfo(
    cvViewModel: CvViewModel = viewModel(),
    currentName: String,
    currentGithubHandle: String,
    currentPhoneNumber: String,
    currentSummaryText: String,
    currentSlackName: String,
    modifier: Modifier = Modifier
) {
    val uiState by cvViewModel.uiState.collectAsState()

    OutlinedTextField(
        value = uiState.currentName,
        onValueChange = {
            cvViewModel.updateCvDetails(uiState.copy(currentName = it))
        },
        modifier = Modifier.padding(5.dp)
    )

    OutlinedTextField(
        value = uiState.currentSlackName,
        onValueChange = {
            cvViewModel.updateCvDetails(uiState.copy(currentSlackName = it))
        },
        modifier = Modifier.padding(5.dp)
    )

    OutlinedTextField(
        value = uiState.currentPhoneNumber,
        onValueChange = {
            cvViewModel.updateCvDetails(uiState.copy(currentPhoneNumber = it))
        },
        modifier = Modifier.padding(5.dp)
    )

    OutlinedTextField(
        value = uiState.currentGithubHandle,
        onValueChange = {
            cvViewModel.updateCvDetails(uiState.copy(currentGithubHandle = it))
        },
        modifier = Modifier.padding(5.dp)
    )

    OutlinedTextField(
        value = uiState.currentSummaryText,
        onValueChange = {
            cvViewModel.updateCvDetails(uiState.copy(currentSummaryText = it))
        },
        modifier = Modifier.padding(5.dp)
    )
}

