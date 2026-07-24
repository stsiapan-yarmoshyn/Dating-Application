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
    val photoUrls: List<String> = emptyList(),
    
    // Ошибки валидации
    val nameError: UiTextUtil? = null,
    val emailError: UiTextUtil? = null,
    val passwordError: UiTextUtil? = null,
    
    // Текущее состояние фокуса (для определения момента потери фокуса)
    val isNameFocused: Boolean = false,
    val isEmailFocused: Boolean = false,
    val isPasswordFocused: Boolean = false,

    // Флаги того, что поле было "тронуто" (пользователь зашел и вышел, или нажал Submit)
    val wasNameFieldFocused: Boolean = false,
    val wasEmailFieldFocused: Boolean = false,
    val wasPasswordFieldFocused: Boolean = false,
    
    val isFormValid: Boolean = false,
    val isLoading: Boolean = false,
) {
    // Ошибки показываем только если поле было "тронуто"
    val showNameError: Boolean get() = wasNameFieldFocused && nameError != null
    val showEmailError: Boolean get() = wasEmailFieldFocused && emailError != null
    val showPasswordError: Boolean get() = wasPasswordFieldFocused && passwordError != null
}
