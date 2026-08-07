package com.example.feature_registration_impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.feature_registration_api.navigation.RegistrationRoute
import com.example.feature_registration_impl.screen.RegistrationViewModel
import com.example.feature_registration_impl.screen.ui.RegistrationScreen
import org.koin.compose.viewmodel.koinViewModel

fun EntryProviderScope<NavKey>.registrationGraph(
    navigateToLogin: () -> Unit,
) {
    entry<RegistrationRoute.Main> {
        val viewModel = koinViewModel<RegistrationViewModel>()
        RegistrationScreen(
            registrationViewModel = viewModel,
            onNavigateToLogin = { id -> navigateToLogin }
        )
    }
}