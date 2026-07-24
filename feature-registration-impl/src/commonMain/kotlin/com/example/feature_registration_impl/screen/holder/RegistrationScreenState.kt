package com.example.feature_registration_impl.screen.holder

import androidx.compose.foundation.ScrollState
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import com.example.feature_registration_impl.screen.RegistrationState
import com.example.feature_registration_impl.screen.RegistrationUiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Stable
class RegistrationScreenState(
    initialName: String,
    initialEmail: String,
    initialPassword: String,
    initialBio: String,
    initialVmState: RegistrationState,
    val snackbarHostState: SnackbarHostState,
    val scrollState: ScrollState,
    val datePickerState: DatePickerState,
    val genderStrings: List<String>,
    private val onEvent: (RegistrationUiEvent) -> Unit,
) {
    // Локальное состояние для плавного ввода
    var name by mutableStateOf(initialName)
        private set

    var email by mutableStateOf(initialEmail)
        private set

    var password by mutableStateOf(initialPassword)
        private set

    var bio by mutableStateOf(initialBio)
        private set

    // Состояние из ViewModel (ошибки, флаги загрузки и т.д.)
    var vmState by mutableStateOf(initialVmState)
        private set

    // Прокси-свойства для удобства
    val nameError get() = if (vmState.showNameError) vmState.nameError else null
    val emailError get() = if (vmState.showEmailError) vmState.emailError else null
    val passwordError get() = if (vmState.showPasswordError) vmState.passwordError else null
    
    val isFormValid get() = vmState.isFormValid
    val isLoading get() = vmState.isLoading
    val photoUrls get() = vmState.photoUrls
    val gender get() = vmState.gender
    val searchGender get() = vmState.searchGender

    fun onNameChanged(newValue: String) {
        name = newValue
        onEvent(RegistrationUiEvent.NameChanged(name))
    }

    fun onEmailChanged(newValue: String) {
        email = newValue
        onEvent(RegistrationUiEvent.EmailChanged(email))
    }

    fun onPasswordChanged(newValue: String) {
        password = newValue
        onEvent(RegistrationUiEvent.PasswordChanged(password))
    }

    fun onBioChanged(newValue: String) {
        bio = newValue
        onEvent(RegistrationUiEvent.AboutChanged(bio))
    }

    fun onNameFocusChanged(hasFocus: Boolean) = onEvent(RegistrationUiEvent.NameFocusChanged(hasFocus))
    fun onEmailFocusChanged(hasFocus: Boolean) = onEvent(RegistrationUiEvent.EmailFocusChanged(hasFocus))
    fun onPasswordFocusChanged(hasFocus: Boolean) = onEvent(RegistrationUiEvent.PasswordFocusChanged(hasFocus))
    fun onBirthDateChanged(millis: Long?) = onEvent(RegistrationUiEvent.BirthDateChanged(millis))
    fun onGenderChanged(gender: String) = onEvent(RegistrationUiEvent.GenderChanged(gender))
    fun onSearchGenderChanged(gender: String) = onEvent(RegistrationUiEvent.SearchGenderChanged(gender))
    fun onPhotoUrlChanged(index: Int, url: String) = onEvent(RegistrationUiEvent.PhotoUrlChanged(index, url))
    fun onAddPhotoField() = onEvent(RegistrationUiEvent.AddPhotoField)
    fun onRemovePhotoField(index: Int) = onEvent(RegistrationUiEvent.RemovePhotoField(index))
    fun onSubmit() = onEvent(RegistrationUiEvent.Submit)

    fun updateFromViewModel(newVmState: RegistrationState) {
        vmState = newVmState
        // Синхронизируем локальные поля только если они изменились во ViewModel извне
        if (name != newVmState.name) name = newVmState.name
        if (email != newVmState.email) email = newVmState.email
        if (password != newVmState.password) password = newVmState.password
        if (bio != newVmState.aboutMe) bio = newVmState.aboutMe
    }

    companion object {
        private const val NAME_KEY = "name"
        private const val EMAIL_KEY = "email"
        private const val PASSWORD_KEY = "password"
        private const val BIO_KEY = "bio"
        private const val DEFAULT_VALUE = ""
        fun saver(
            snackbarHostState: SnackbarHostState,
            scrollState: ScrollState,
            datePickerState: DatePickerState,
            genderStrings: List<String>,
            vmState: RegistrationState,
            onEvent: (RegistrationUiEvent) -> Unit
        ): Saver<RegistrationScreenState, Map<String, Any>> = Saver(
            save = {
                mapOf(
                    NAME_KEY to it.name,
                    EMAIL_KEY to it.email,
                    PASSWORD_KEY to it.password,
                    BIO_KEY to it.bio
                )
            },
            restore = {
                RegistrationScreenState(
                    initialName = it[NAME_KEY] as? String ?: DEFAULT_VALUE,
                    initialEmail = it[EMAIL_KEY] as? String ?: DEFAULT_VALUE,
                    initialPassword = it[PASSWORD_KEY] as? String ?: DEFAULT_VALUE,
                    initialBio = it[BIO_KEY] as? String ?: DEFAULT_VALUE,
                    genderStrings = genderStrings,
                    initialVmState = vmState,
                    snackbarHostState = snackbarHostState,
                    scrollState = scrollState,
                    datePickerState = datePickerState,
                    onEvent = onEvent
                )
            }
        )
    }
}
