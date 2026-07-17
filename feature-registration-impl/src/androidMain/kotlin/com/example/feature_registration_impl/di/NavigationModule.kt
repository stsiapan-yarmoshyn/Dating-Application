package com.example.feature_registration_impl.di

import com.example.feature_registration_api.navigation.RegistrationNavHandler
import com.example.feature_registration_impl.navigation.RegistrationNavHandlerImpl
import dagger.Binds
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
    fun provideRegistrationNavHandler(): RegistrationNavHandler {
        return RegistrationNavHandlerImpl()
    }
}