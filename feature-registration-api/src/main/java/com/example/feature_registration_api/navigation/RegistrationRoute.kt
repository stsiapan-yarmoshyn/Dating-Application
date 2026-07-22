package com.example.feature_registration_api.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface RegistrationRoute: NavKey {
    @Serializable
    data object Main: RegistrationRoute
}