package com.example.feature_registration_api.navigation

import com.example.core_navigation_api.NavRouterCommand


sealed interface RegistrationNavigationCommand : NavRouterCommand
data class NavigateToLoginScreen(val userId: String): RegistrationNavigationCommand