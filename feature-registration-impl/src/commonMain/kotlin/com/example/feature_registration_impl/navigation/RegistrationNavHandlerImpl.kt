package com.example.feature_registration_impl.navigation

import com.example.core_navigation_api.FeatureDestination
import com.example.feature_registration_api.navigation.NavigateToLoginScreen
import com.example.feature_registration_api.navigation.RegistrationDestination.*
import com.example.feature_registration_api.navigation.RegistrationNavHandler
import com.example.feature_registration_api.navigation.RegistrationNavigationCommand

class RegistrationNavHandlerImpl: RegistrationNavHandler {
    override fun getDestination(command: RegistrationNavigationCommand): FeatureDestination {
        return when(command) {
            is NavigateToLoginScreen -> {
                LoginScreen(command.userId)
            }
        }
    }

}