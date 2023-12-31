package com.example.mycurriculumvitae.ui.screens

import android.util.Log
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycurriculumvitae.model.CVUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class CvViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CVUiState())
    val uiState: StateFlow<CVUiState> = _uiState.asStateFlow()


    //set Ui to user input
    fun updateCvDetails(updatedInfo: CVUiState) {
        _uiState.value = updatedInfo

    }

    // Function to update the initial data for CVUiState
    fun updateInitialData(newData: CVUiState) {
        _uiState.value = newData
    }


}

