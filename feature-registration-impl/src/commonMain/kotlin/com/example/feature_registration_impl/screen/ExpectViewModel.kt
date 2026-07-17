package com.example.feature_registration_impl.screen

import androidx.compose.runtime.Composable

// Определяем, что на каждой платформе будет свой способ достать эту ViewModel
@Composable
expect fun rememberRegistrationViewModel(): RegistrationViewModel