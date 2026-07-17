package com.example.feature_registration_impl.di

import com.example.core_navigation_api.NavigationDispatcher
import com.example.feature_registration_api.usecase.FeatureRegistrationUseCase
import com.example.feature_registration_impl.screen.RegistrationViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped

//@Module
//@InstallIn(ViewModelComponent::class)
//object RegistrationUiModule {
//
//    @Provides
//    @ViewModelScoped
//    fun provideRegistrationViewModel(
//        registerUserUseCase: FeatureRegistrationUseCase,
//        navigationDispatcher: NavigationDispatcher
//    ): RegistrationViewModel {
//        return RegistrationViewModel(
//            navigationDispatcher = navigationDispatcher,
//            registerUserUseCase = registerUserUseCase
//        )
//    }
//
//}