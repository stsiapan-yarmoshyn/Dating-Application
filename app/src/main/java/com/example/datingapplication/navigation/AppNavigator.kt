package com.example.datingapplication.navigation

import androidx.navigation.NavController
import com.example.core_navigation_api.NavRouterCommand
import com.example.feature_registration_api.navigation.RegistrationNavHandler
import com.example.feature_registration_api.navigation.RegistrationNavigationCommand

class AppNavigator(
    private val registrationHandler: RegistrationNavHandler,
    private val adapters: List<FeatureNavAdapter>,
    private val navController: NavController
) {
    fun handleCommand(command: NavRouterCommand) {
        // 1. Пытаемся получить дестинацию от фичи
        val destination = when (command) {
            is RegistrationNavigationCommand -> registrationHandler.getDestination(command)
            else -> null
        }

        // 2. Если фича вернула дестинацию, ищем адаптер, который умеет её открывать
        if (destination != null) {
            for (adapter in adapters) {
                if (adapter.handleDestination(destination, navController)) {
                    break
                }
            }
        }
    }
}