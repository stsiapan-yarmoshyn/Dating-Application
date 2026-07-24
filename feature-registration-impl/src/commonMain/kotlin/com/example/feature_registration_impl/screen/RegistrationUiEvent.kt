package com.example.feature_registration_impl.screen

sealed interface RegistrationUiEvent {
    data class NameChanged(val name: String) : RegistrationUiEvent
    data class EmailChanged(val email: String) : RegistrationUiEvent
    data class PasswordChanged(val password: String) : RegistrationUiEvent
    data class AboutChanged(val about: String) : RegistrationUiEvent
    data class GenderChanged(val gender: String) : RegistrationUiEvent
    data class SearchGenderChanged(val gender: String) : RegistrationUiEvent
    data class BirthDateChanged(val millis: Long?) : RegistrationUiEvent
    data class PhotoUrlChanged(val index: Int, val url: String) : RegistrationUiEvent
    data object AddPhotoField : RegistrationUiEvent
    data class RemovePhotoField(val index: Int) : RegistrationUiEvent

    //Focus changed
    data class EmailFocusChanged(val hasFocus: Boolean) : RegistrationUiEvent
    data class PasswordFocusChanged(val hasFocus: Boolean) : RegistrationUiEvent
    data class NameFocusChanged(val hasFocus: Boolean) : RegistrationUiEvent

    data object Submit : RegistrationUiEvent
}