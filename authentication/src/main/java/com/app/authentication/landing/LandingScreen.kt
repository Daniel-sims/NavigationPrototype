package com.app.authentication.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.material.icons.rounded.Mail
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.app.authentication.R

@Composable
fun LandingScreen(
    viewModel: LandingViewModel
) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            HeaderContent()
            ButtonContent(
                onLoginWithGoogleClicked = {
                    viewModel.navigate()
                },
                onLoginWithFacebookClicked = {},
                onLoginWithEmailClicked = {},
                onSignUpClicked = {}
            )
        }
    }
}

@Composable
private fun HeaderContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_teamrh_logo),
            contentDescription = "",
            modifier = Modifier
                .heightIn(min = 180.dp)
                .fillMaxWidth()

        )
        Text(
            text = "Team RH, and some more title here",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp)
        )

        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = "This is a sub title with some more stuff in it!",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(all = 32.dp)
            )
        }
    }
}

@Composable
private fun ButtonContent(
    onLoginWithGoogleClicked: () -> Unit,
    onLoginWithFacebookClicked: () -> Unit,
    onLoginWithEmailClicked: () -> Unit,
    onSignUpClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        // Google
        LandingScreenSocialsButton(
            onButtonClick = onLoginWithGoogleClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google_logo),
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )

            Text(
                text = "Login with Google",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Facebook
        LandingScreenSocialsButton(
            onButtonClick = onLoginWithFacebookClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Icon(
                Icons.Rounded.Facebook,
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )

            Text(
                text = "Login with Facebook",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // OR text
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .weight(0.4f)
                    .align(Alignment.CenterVertically)
                    .background(MaterialTheme.colors.primary.copy(alpha = 0.3f))
            )

            CompositionLocalProvider(
                LocalContentAlpha provides ContentAlpha.medium
            ) {
                Text(
                    text = "Or",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .weight(0.4f)
                    .align(Alignment.CenterVertically)
                    .background(MaterialTheme.colors.primary.copy(alpha = 0.3f))
            )
        }

        // Email
        LandingScreenEmailButton(
            onButtonClick = onLoginWithEmailClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Icon(
                Icons.Rounded.Mail,
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )

            Text(
                text = "Login with Email",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Don't have an account?
        SignUpText(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            onSignUpClicked = onSignUpClicked
        )
    }
}

@Composable
private fun SignUpText(
    modifier: Modifier = Modifier,
    onSignUpClicked: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        append("Don't have an account? ")


        pushStringAnnotation(tag = "url", annotation = "www.google.com")
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("Sign up")
        }

        pop()
    }

    ClickableText(
        modifier = modifier,
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "url",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                onSignUpClicked()
            }
        })
}

@Composable
private fun LandingScreenSocialsButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onButtonClick,
        modifier = modifier.padding(vertical = 8.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
        ) {
            content()
        }
    }
}

@Composable
private fun LandingScreenEmailButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    content: @Composable () -> Unit
) {
    OutlinedButton(
        onClick = onButtonClick,
        modifier = modifier.padding(vertical = 8.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
        ) {
            content()
        }
    }
}