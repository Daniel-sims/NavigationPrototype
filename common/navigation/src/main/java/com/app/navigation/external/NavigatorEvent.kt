package com.app.navigation.external

import androidx.navigation.NavOptionsBuilder

sealed class NavigatorEvent {
    object NavigateUp : NavigatorEvent()
    class Directions(val destination: String, val builder: NavOptionsBuilder.() -> Unit) : NavigatorEvent()
}