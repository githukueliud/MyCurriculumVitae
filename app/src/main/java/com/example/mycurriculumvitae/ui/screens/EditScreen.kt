package com.example.mycurriculumvitae.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycurriculumvitae.R
import com.example.mycurriculumvitae.model.CVUiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    onSaveButtonClicked: () -> Unit,
    cvViewModel: CvViewModel,
    modifier: Modifier = Modifier
) {

    val cVUiState by cvViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = cVUiState.currentName,
            onValueChange = {
                cvViewModel.updateCvDetails(cVUiState.copy(currentName = it))
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text(text = "Edit current name")}
        )
        OutlinedTextField(
            value = cVUiState.currentSlackName,
            onValueChange = {
                cvViewModel.updateCvDetails(cVUiState.copy(currentSlackName = it))

            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text(text = stringResource(R.string.edit_current_name))}
        )

        OutlinedTextField(
            value = cVUiState.currentPhoneNumber,
            onValueChange = {
                cvViewModel.updateCvDetails(cVUiState.copy(currentPhoneNumber = it))
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text(text = stringResource(R.string.edit_current_slack_name))}
        )

        OutlinedTextField(
            value = cVUiState.currentGithubHandle,
            onValueChange = {
                cvViewModel.updateCvDetails(cVUiState.copy(currentGithubHandle = it))
            },
            singleLine = true ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text(text = stringResource(R.string.edit_github_handle))}
        )

        OutlinedTextField(
            value = cVUiState.currentSummaryText,
            onValueChange = {
                cvViewModel.updateCvDetails(cVUiState.copy(currentSummaryText = it))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text(text = stringResource(R.string.edit_bio_summary))}
        )
        OutlinedTextField(
            value = cVUiState.currentInternshipDuration,
            onValueChange = {
                cvViewModel.updateCvDetails(cVUiState.copy(currentInternshipDuration = it))
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text(text = stringResource(R.string.edit_internship_duration))}
        )
        Button(
            onClick = {
                // Save the edited info by calling the view model function
                cvViewModel.updateCvDetails(cVUiState)
                onSaveButtonClicked()

            },
            modifier = Modifier.padding(5.dp)
                .height(50.dp)
                .fillMaxWidth(0.7f)
        ) {
            Text(
                text = stringResource(R.string.save_changes),
                fontSize = 15.sp
            )
        }
    }
}




//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun EditPersonalInfo(
//    cvViewModel: CvViewModel = viewModel(),
//    currentName: String,
//    currentGithubHandle: String,
//    currentPhoneNumber: String,
//    currentSummaryText: String,
//    currentSlackName: String,
//    modifier: Modifier = Modifier
//) {
//    val uiState by cvViewModel.uiState.collectAsState()
//
//
//
//
//}

