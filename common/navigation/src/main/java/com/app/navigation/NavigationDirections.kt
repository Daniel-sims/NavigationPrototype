package com.app.navigation

import androidx.navigation.compose.NamedNavArgument

object NavigationDirections {

    val authentication  = object : INavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "authentication"

    }

    val dashboard = object : INavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "dashboard"
    }
}