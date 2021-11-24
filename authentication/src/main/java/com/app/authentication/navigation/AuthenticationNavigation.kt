package com.app.authentication.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.app.authentication.landing.LandingScreen
import com.app.authentication.signin.SignInScreen
import com.app.navigation.external.destinations.authentication.AuthenticationNavigationDirections
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.addAuthenticationDestinations() {
    navigation(
        route = AuthenticationNavigationDirections.root.route(),
        startDestination = AuthenticationNavigationDirections.landing_screen.route()
    ) {
        composable(
            route = AuthenticationNavigationDirections.landing_screen.route(),
            enterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700))
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700))
            },
            popEnterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700))
            },
            popExitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700))
            }
        ) {
            LandingScreen(hiltViewModel())
        }

        composable(
            route = AuthenticationNavigationDirections.sign_in_screen.route(),
            enterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700))
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700))
            },
            popEnterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700))
            },
            popExitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700))
            }
        ) {
            SignInScreen(hiltViewModel())
        }
    }
}
