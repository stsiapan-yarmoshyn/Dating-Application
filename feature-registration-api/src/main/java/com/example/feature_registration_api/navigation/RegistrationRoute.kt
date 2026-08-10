package com.example.feature_registration_api.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface RegistrationRoute: NavKey {
    @Serializable
    @SerialName("RegistrationMain")
    data object RegistrationMain: RegistrationRoute
}