package com.example.feature_registration_impl.screen

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.feature_registration_impl.ui.AndroidRegistrationViewModel

@Composable
actual fun rememberRegistrationViewModel(): RegistrationViewModel {
    return hiltViewModel<AndroidRegistrationViewModel>()
}