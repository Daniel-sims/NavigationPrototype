package com.app.navigation.internal

import androidx.navigation.NavOptionsBuilder
import com.app.navigation.external.Navigator
import com.app.navigation.external.NavigatorEvent
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Singleton
internal class NavigatorImpl @Inject constructor() : Navigator {

    private val navigationEvents = Channel<NavigatorEvent>()
    override val destinations = navigationEvents.receiveAsFlow()

    override fun navigateUp(): Boolean =
        navigationEvents.trySend(NavigatorEvent.NavigateUp).isSuccess

    override fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit): Boolean =
        navigationEvents.trySend(NavigatorEvent.Directions(route, builder)).isSuccess

}