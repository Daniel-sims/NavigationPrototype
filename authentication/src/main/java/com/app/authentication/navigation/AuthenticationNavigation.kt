package com.app.authentication.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.authentication.landing.LandingScreen
import com.app.authentication.signin.SignInScreen
import com.app.navigation.external.destinations.authentication.AuthenticationNavigationDirections

fun NavGraphBuilder.addAuthenticationDestinations() {
    navigation(
        route = AuthenticationNavigationDirections.root.route(),
        startDestination = AuthenticationNavigationDirections.landing_screen.route()
    ) {
        composable(AuthenticationNavigationDirections.landing_screen.route()) {
            LandingScreen(hiltViewModel())
        }

        composable(AuthenticationNavigationDirections.sign_in_screen.route()) {
            SignInScreen(hiltViewModel())
        }
    }
}