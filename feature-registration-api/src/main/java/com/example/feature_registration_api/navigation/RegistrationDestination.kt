package com.example.feature_registration_api.navigation

import com.example.core_navigation_api.FeatureDestination

sealed interface RegistrationDestination : FeatureDestination {
    data class LoginScreen(val userId: String): RegistrationDestination
}
