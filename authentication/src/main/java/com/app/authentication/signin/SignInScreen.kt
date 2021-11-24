package com.app.authentication.signin

import androidx.compose.foundation.clickable
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Mail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun SignInScreen(
    viewModel: SignInViewModel,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = modifier,
                
                title = { Text(text = "text") },
                navigationIcon = {
                    Icon(
                        Icons.Rounded.Mail,
                        contentDescription = null,
                        Modifier.clickable {
                            viewModel.navigateBack()
                        }
                    )
                },
            )
        }
    ) {
        Button(onClick = { viewModel.navigateBack() }) {
            Text(text = "This is a button")
        }
    }
}