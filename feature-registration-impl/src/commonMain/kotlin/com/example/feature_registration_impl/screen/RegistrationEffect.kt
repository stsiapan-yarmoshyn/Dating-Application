package com.example.feature_registration_impl.screen

import com.example.feature_registration_impl.util.UiTextUtil

sealed interface RegistrationEffect {

    data class NetworkError(val message: UiTextUtil) : RegistrationEffect
    object Success : RegistrationEffect

}