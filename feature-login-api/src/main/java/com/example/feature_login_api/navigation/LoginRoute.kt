package com.example.feature_login_api.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface LoginRoute: NavKey {
    @Serializable
    @SerialName("LoginMain")
    data object LoginMain: LoginRoute
}