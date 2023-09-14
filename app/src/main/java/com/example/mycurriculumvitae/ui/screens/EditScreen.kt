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


@Composable
fun EditScreen(
    onSaveButtonClicked: () -> Unit,
    cvViewModel: CvViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val cVUiState by cvViewModel.uiState.collectAsState()

    // Declare different variable names for TextFieldValue objects
    var currentNameValue by remember { mutableStateOf(TextFieldValue(cVUiState.currentName)) }
    var currentGithubHandleValue by remember { mutableStateOf(TextFieldValue(cVUiState.currentGithubHandle)) }
    var currentPhoneNumberValue by remember { mutableStateOf(TextFieldValue(cVUiState.currentPhoneNumber)) }
    var currentSummaryTextValue by remember { mutableStateOf(TextFieldValue(cVUiState.currentSummaryText)) }
    var currentSlackNameValue by remember { mutableStateOf(TextFieldValue(cVUiState.currentSlackName)) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditPersonalInfo(
            modifier = modifier,
            currentName = currentNameValue.text,
            currentGithubHandle = currentGithubHandleValue.text,
            currentPhoneNumber = currentPhoneNumberValue.text,
            currentSummaryText = currentSummaryTextValue.text,
            currentSlackName = currentSlackNameValue.text
        )
        Button(
            onClick = {
                val editedInfo = CVUiState(
                    currentName = currentNameValue.text,
                    currentGithubHandle = currentGithubHandleValue.text,
                    currentPhoneNumber = currentPhoneNumberValue.text,
                    currentSummaryText = currentSummaryTextValue.text,
                    currentSlackName = currentSlackNameValue.text
                )
                //update the viewmodel
                cvViewModel.updateCvDetails(editedInfo)
                // Print a message to Logcat
                Log.d("MyApp", "Updated UI State: $editedInfo")
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
    var currentName by remember { mutableStateOf(TextFieldValue(cvViewModel.uiState.value.currentName)) }
    var currentGithubHandle by remember { mutableStateOf(TextFieldValue(cvViewModel.uiState.value.currentGithubHandle)) }
    var currentPhoneNumber by remember { mutableStateOf(TextFieldValue(cvViewModel.uiState.value.currentPhoneNumber)) }
    var currentSummaryText by remember { mutableStateOf(TextFieldValue(cvViewModel.uiState.value.currentSummaryText)) }
    var currentSlackName by remember { mutableStateOf(TextFieldValue(cvViewModel.uiState.value.currentSlackName)) }
    OutlinedTextField(
        value = currentName,
        onValueChange = { currentName = it },
        modifier = Modifier.padding(5.dp)
    )

    OutlinedTextField(
        value = currentSlackName,
        onValueChange = { currentSlackName = it },
        modifier = Modifier.padding(5.dp)
    )

    OutlinedTextField(
        value = currentPhoneNumber,
        onValueChange = { currentPhoneNumber = it },
        modifier = Modifier.padding(5.dp)
    )

    OutlinedTextField(
        value = currentGithubHandle,
        onValueChange = { currentGithubHandle = it } ,
        modifier = Modifier.padding(5.dp)
    )

    OutlinedTextField(
        value = currentSummaryText,
        onValueChange = { currentSummaryText = it } ,
        modifier = Modifier.padding(5.dp)
    )
}