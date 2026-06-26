package com.example.feature_registration_impl.screen

data class RegistrationUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val aboutMe: String = "",
    val gender: String = "",
    val searchGender: String = "",
    val birthDateMillis: Long? = null,
    val photoUrls: List<String> = listOf(""),
    //Validation error
    val nameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val isFormValid: Boolean = false,
    val isLoading: Boolean = false,
)