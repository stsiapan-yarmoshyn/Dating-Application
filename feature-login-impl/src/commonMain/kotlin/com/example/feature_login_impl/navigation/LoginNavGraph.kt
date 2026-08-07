package com.example.feature_login_impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.feature_login_api.navigation.LoginRoute
import com.example.feature_login_impl.screen.LoginViewModel
import com.example.feature_login_impl.screen.ui.LoginScreen
import org.koin.compose.viewmodel.koinViewModel

fun EntryProviderScope<NavKey>.loginGraph(
    navigateToMatching: () -> Unit,
) {
    entry<LoginRoute.Main> {
        val viewModel = koinViewModel<LoginViewModel>()
        LoginScreen(
            loginViewModel = viewModel,
            onNavigateToMatching = navigateToMatching
        )
    }
}