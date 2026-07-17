package com.example.feature_registration_impl.screen.holder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.feature_registration_impl.screen.RegistrationUiEvent
import androidx.compose.runtime.saveable.Saver


class RegistrationScreenState(
    initialName: String,
    initialEmail: String,
    initialPassword: String,
    initialBio: String,
    private val onEvent: (RegistrationUiEvent) -> Unit,
) {

    var name by mutableStateOf(initialName)
        private set

    var email by mutableStateOf(initialEmail)
        private set

    var password by mutableStateOf(initialPassword)
        private set

    var bio by mutableStateOf(initialBio)
        private set


    fun onNameChanged(newValue: String) {
        name = newValue
        onEvent(RegistrationUiEvent.NameChanged(newValue))
    }

    fun onEmailChanged(newValue: String) {
        email = newValue
        onEvent(RegistrationUiEvent.EmailChanged(newValue))
    }

    fun onPasswordChanged(newValue: String) {
        password = newValue
        onEvent(RegistrationUiEvent.PasswordChanged(newValue))
    }

    fun onBioChanged(newValue: String) {
        bio = newValue
        onEvent(RegistrationUiEvent.AboutChanged(newValue))
    }


    fun updateFromViewModel(
        newName: String,
        newEmail: String,
        newPassword: String,
        newBio: String,
    ) {
        if (name != newName) name = newName
        if (email != newEmail) email = newEmail
        if (password != newPassword) password = newPassword
        if (bio != newBio) bio = newBio
    }

    companion object {
        private const val NAME_KEY = "name"
        private const val EMAIL_KEY = "email"
        private const val PASSWORD_KEY = "password"
        private const val BIO_KEY = "bio"
        private const val DEFAULT_VALUE = ""

        fun saver(onEvent: (RegistrationUiEvent) -> Unit): Saver<RegistrationScreenState, Map<String, Any>> {
            return Saver(
                save = { state ->
                    mapOf(
                        NAME_KEY to state.name,
                        EMAIL_KEY to state.email,
                        PASSWORD_KEY to state.password,
                        BIO_KEY to state.bio,
                    )
                },
                restore = { map ->
                    RegistrationScreenState(
                        initialName = map[NAME_KEY] as? String ?: DEFAULT_VALUE,
                        initialEmail = map[EMAIL_KEY] as? String ?: DEFAULT_VALUE,
                        initialPassword = map[PASSWORD_KEY] as? String ?: DEFAULT_VALUE,
                        initialBio = map[BIO_KEY] as? String ?: DEFAULT_VALUE,
                        onEvent = onEvent
                    )
                }
            )
        }
    }
}
