package com.app.navigationprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.authentication.navigation.addAuthenticationDestinations
import com.app.dashboard.DashboardScreen
import com.app.navigation.external.Navigator
import com.app.navigation.external.NavigatorEvent
import com.app.navigation.external.destinations.DashboardNavigation
import com.app.navigation.external.destinations.authentication.AuthenticationNavigationDirections
import com.app.styles.theme.NavigationPrototypeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationPrototypeTheme {
                SetSystemBarTransparent()

                RhAppNavigation(navigator = navigator)
            }
        }
    }
}

@Composable
private fun RhAppNavigation(navigator: Navigator) {
    val navController = rememberNavController()

    /**
     * Observer the navigator for navigation events from the modules
     * ready to navigate around.
     */
    LaunchedEffect(navController) {
        navigator.destinations.collectLatest {
            when (val event = it) {
                is NavigatorEvent.Directions -> navController.navigate(
                    event.destination,
                    event.builder
                )
                NavigatorEvent.NavigateUp -> navController.navigateUp()
            }
        }
    }

    /**
     * Create the navigation host adding the navigation graphs from the
     */
    NavHost(
        navController = navController,
        startDestination = AuthenticationNavigationDirections.root.route()
    ) {
        addAuthenticationDestinations()
    }
}

@Composable
private fun SetSystemBarTransparent() {
    // Remember a SystemUiController
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight

    SideEffect {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
    }

}