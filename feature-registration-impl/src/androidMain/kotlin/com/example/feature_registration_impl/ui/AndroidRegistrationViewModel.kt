package com.example.feature_registration_impl.ui

import com.example.core_navigation_api.NavigationDispatcher
import com.example.feature_registration_api.usecase.FeatureRegistrationUseCase
import com.example.feature_registration_impl.screen.RegistrationViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidRegistrationViewModel @Inject constructor(
    registerUserUseCase: FeatureRegistrationUseCase,
    navigationDispatcher: NavigationDispatcher
) : RegistrationViewModel(registerUserUseCase, navigationDispatcher)