package com.example.mycurriculumvitae.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun EditScreen(
    navigateToHomeScreen: () -> Unit
) {
    Button(onClick = { navigateToHomeScreen}) {
        Text(text = "Save")
    }
}

@Composable
fun EditPersonalInfo(
    name: String,
    image: Int,
    email: String,
    phoneNumber: String
) {

}