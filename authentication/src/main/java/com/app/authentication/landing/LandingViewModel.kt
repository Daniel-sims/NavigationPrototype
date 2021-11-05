package com.app.authentication.landing

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.app.navigation.external.Navigator
import com.app.navigation.external.destinations.DashboardNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val navigator : Navigator
) : ViewModel() {

    fun navigate() {
            navigator.navigate(
                DashboardNavigation.createDashboardRoute()
            )
    }
}