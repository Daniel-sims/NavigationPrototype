package com.app.navigation.external.destinations.authentication

import com.app.navigation.external.NavigationDestination

object AuthenticationNavigationDirections {
    val root = object : NavigationDestination {
        private val LANDING_SCREEN_ROUTE = "auth_root"
        override fun route(): String = LANDING_SCREEN_ROUTE
    }

    val landing_screen = object : NavigationDestination {
        private val LANDING_SCREEN_ROUTE = "landing_screen"
        override fun route(): String = LANDING_SCREEN_ROUTE
    }

    val sign_in_screen =  object : NavigationDestination {
        private val SIGN_IN_ROUTE = "sign_in_route"
        override fun route(): String = SIGN_IN_ROUTE
    }
}