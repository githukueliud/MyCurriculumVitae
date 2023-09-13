package com.example.mycurriculumvitae.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycurriculumvitae.model.CVUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CvViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CVUiState())
    val uiState: StateFlow<CVUiState> = _uiState.asStateFlow()

    private val _editScreenIsShown = MutableStateFlow(false)
    val editScreenIsShown: StateFlow<Boolean> = _editScreenIsShown

    fun showEditScreen() {
        viewModelScope.launch {
            _editScreenIsShown.value = true
        }
    }

    fun hideEditScreen() {
        viewModelScope.launch {
            _editScreenIsShown.value = false
        }
    }

    var userInput by mutableStateOf(uiState.value)
        private set

    fun updateCvDetails(userInput: CVUiState) {
        viewModelScope.launch {
            _uiState.value = userInput
        }
    }
}