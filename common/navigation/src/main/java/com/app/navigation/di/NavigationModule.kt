package com.app.navigation.di

import com.app.navigation.INavigationManager
import com.app.navigation.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun providesNavigationManager() : INavigationManager = NavigationManager()

}