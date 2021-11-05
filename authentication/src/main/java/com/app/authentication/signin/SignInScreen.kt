package com.app.authentication.signin

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


@Composable
fun SignInScreen(
    viewModel: SignInViewModel
) {
    Button(onClick = { viewModel.navigateBack() }) {
        Text(text = "This is a button")
    }
}