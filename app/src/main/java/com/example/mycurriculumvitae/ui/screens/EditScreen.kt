package com.example.mycurriculumvitae.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun EditScreen(
    onSaveButtonClicked: ()-> Unit,
    cvViewModel: CvViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val cVUiState by cvViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditPersonalInfo(
            modifier = modifier,
            currentName = cVUiState.currentName,
            currentGithubHandle = cVUiState.currentGithubHandle,
            currentPhoneNumber = cVUiState.currentPhoneNumber,
            currentSummaryText = cVUiState.currentSummaryText,
            currentSlackName = cVUiState.currentSlackName
        )
        Button(onClick = onSaveButtonClicked ) {
            Text(text = "Save")
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPersonalInfo(
    currentName: String,
    currentGithubHandle: String,
    currentPhoneNumber: String,
    currentSummaryText: String,
    currentSlackName: String,
    modifier: Modifier = Modifier
) {
    var currentName by remember { mutableStateOf(TextFieldValue(currentName)) }
    var currentGithubHandle by remember { mutableStateOf(TextFieldValue(currentGithubHandle)) }
    var currentPhoneNumber by remember { mutableStateOf(TextFieldValue(currentPhoneNumber)) }
    var currentSummaryText by remember { mutableStateOf(TextFieldValue(currentSummaryText)) }
    var currentSlackName by remember { mutableStateOf(TextFieldValue(currentSlackName)) }
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
}