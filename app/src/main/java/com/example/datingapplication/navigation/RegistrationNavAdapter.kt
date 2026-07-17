package com.example.datingapplication.navigation

import androidx.navigation.NavController
import com.example.core_navigation_api.FeatureDestination
import com.example.feature_registration_api.navigation.RegistrationDestination

class RegistrationNavAdapter : FeatureNavAdapter {
    override fun handleDestination(destination: FeatureDestination, navController: NavController): Boolean {
        if (destination !is RegistrationDestination) return false

        return when (destination) {
            is RegistrationDestination.LoginScreen -> {
                navController.navigate("login/${destination.userId}")
                true
            }
        }
    }
}