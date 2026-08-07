package com.example.feature_login_impl.screen

import com.example.feature_login_impl.util.UiTextUtil

sealed interface LoginEffect {

    data class Error(val message: UiTextUtil) : LoginEffect
    data object Success : LoginEffect

}