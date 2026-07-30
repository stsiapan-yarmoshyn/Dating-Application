package com.example.feature_registration_impl.screen

import com.example.feature_registration_impl.util.UiTextUtil

data class RegistrationState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val aboutMe: String = "",
    val gender: String = "",
    val searchGender: String = "",
    val birthDateMillis: Long? = null,
    val photoUrls: List<String> = listOf(""),
    //Validation error
    val nameError: UiTextUtil? = null,
    val emailError: UiTextUtil? = null,
    val passwordError: UiTextUtil? = null,
    val isFormValid: Boolean = false,
    val isLoading: Boolean = false,
)