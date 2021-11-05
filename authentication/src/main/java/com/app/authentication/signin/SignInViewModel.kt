package com.app.authentication.signin

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.app.navigation.external.Navigator
import com.app.navigation.external.destinations.DashboardNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val navigator: Navigator
) : ViewModel() {

    fun navigateBack() {
        navigator.navigateUp()
    }
}