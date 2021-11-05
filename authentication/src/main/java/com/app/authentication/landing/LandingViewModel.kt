package com.app.authentication.landing

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.app.navigation.INavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val navigationManager: INavigationManager
) : ViewModel() {

    fun navigate() {
        val x = 1
    }
}