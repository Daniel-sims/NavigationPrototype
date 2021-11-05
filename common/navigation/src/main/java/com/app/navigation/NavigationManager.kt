package com.app.navigation

import kotlinx.coroutines.flow.MutableStateFlow

internal class NavigationManager : INavigationManager {

    var commands = MutableStateFlow(NavigationDirections.dashboard)

    fun navigate(
        directions: INavigationCommand
    ) {
        commands.value = directions
    }
}