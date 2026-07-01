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
    object AddPhotoField : RegistrationUiEvent
    data class RemovePhotoField(val index: Int) : RegistrationUiEvent
    object Submit : RegistrationUiEvent //TODO
}