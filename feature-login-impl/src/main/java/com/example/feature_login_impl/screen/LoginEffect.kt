package com.example.feature_login_impl.screen

import com.example.feature_login_impl.util.UiTextUtil

sealed interface LoginEffect {

    @JvmInline
    value class Error(val message: UiTextUtil) : LoginEffect
    object Success : LoginEffect

}