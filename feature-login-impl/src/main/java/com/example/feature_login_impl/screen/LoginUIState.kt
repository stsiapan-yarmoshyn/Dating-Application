package com.example.feature_login_impl.screen

import com.example.feature_login_impl.util.UiTextUtil

data class LoginUIState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isButtonEnabled: Boolean = false,
    val isLoginSuccess: Boolean = false,
    val errorMessage: UiTextUtil? = null
)