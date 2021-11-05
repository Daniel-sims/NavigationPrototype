package com.app.navigation.internal

import com.app.navigation.external.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NavigatorModule {

    @Binds
    abstract fun navigator(navigator: NavigatorImpl): Navigator
}