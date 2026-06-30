package com.example.feature_login_impl.screen

sealed interface LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent
    data class PasswordChanged(val password: String) : LoginEvent
    object LoginButtonClicked : LoginEvent
}