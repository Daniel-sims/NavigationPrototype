package com.app.navigation.external

import androidx.navigation.compose.NamedNavArgument

internal fun interface NavigationDestination {

    fun route(): String
    val arguments: List<NamedNavArgument>
        get() = emptyList()
}