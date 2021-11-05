package com.app.navigation

import androidx.navigation.compose.NamedNavArgument

interface INavigationCommand {
    val arguments : List<NamedNavArgument>
    val destination : String
}