package com.example.feature_login_api.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface LoginRoute: NavKey {
    @Serializable
    data object Main: LoginRoute
}