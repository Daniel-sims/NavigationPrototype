package com.app.navigationprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.authentication.landing.LandingScreen
import com.app.dashboard.DashboardScreen
import com.app.navigation.NavigationDirections
import com.app.styles.theme.NavigationPrototypeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationPrototypeTheme {
                SetSystemBarTransparent()

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavigationDirections.authentication.destination
                ) {
                    composable(NavigationDirections.dashboard.destination) {
                        DashboardScreen(hiltViewModel())
                    }

                    composable(NavigationDirections.authentication.destination) {
                        LandingScreen(hiltViewModel())
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationPrototypeTheme {
        //  LandingScreen()
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