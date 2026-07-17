package com.example.feature_registration_api.navigation

import com.example.core_navigation_api.FeatureDestination

interface RegistrationNavHandler {
    fun getDestination(command: RegistrationNavigationCommand): FeatureDestination?
}