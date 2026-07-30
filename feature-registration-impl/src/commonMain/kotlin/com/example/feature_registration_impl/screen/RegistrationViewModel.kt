package com.example.feature_registration_impl.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_registration_api.usecase.FeatureRegistrationUseCase
import com.example.feature_registration_impl.data.mapper.toFeatureModel
import com.example.feature_registration_impl.util.UiTextUtil
import datingapplication.feature_registration_impl.generated.resources.Res
import datingapplication.feature_registration_impl.generated.resources.email_error_text
import datingapplication.feature_registration_impl.generated.resources.gender_female_text
import datingapplication.feature_registration_impl.generated.resources.gender_male_text
import datingapplication.feature_registration_impl.generated.resources.gender_other_text
import datingapplication.feature_registration_impl.generated.resources.name_error_text
import datingapplication.feature_registration_impl.generated.resources.password_error_text
import datingapplication.feature_registration_impl.generated.resources.unknown_error_text
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import java.util.logging.Logger

open class RegistrationViewModel(
    private val registerUserUseCase: FeatureRegistrationUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(RegistrationState())
    val state: StateFlow<RegistrationState> = _state.asStateFlow()

    private val _effect = Channel<RegistrationEffect>()
    val effect = _effect.receiveAsFlow()

    val genderList: List<StringResource>
        get() = listOf(
            Res.string.gender_male_text,
            Res.string.gender_female_text,
            Res.string.gender_other_text
        )

    fun handleIntent(event: RegistrationUiEvent) {
        when (event) {
            is RegistrationUiEvent.AboutChanged -> updateAbout(event.about)
            is RegistrationUiEvent.BirthDateChanged -> updateBirthday(event.millis)
            is RegistrationUiEvent.EmailChanged -> updateEmail(event.email)
            is RegistrationUiEvent.GenderChanged -> updateGender(event.gender)
            is RegistrationUiEvent.SearchGenderChanged -> updateSearchGender(event.gender)
            is RegistrationUiEvent.NameChanged -> updateName(event.name)
            is RegistrationUiEvent.PhotoUrlChanged -> updatePhotoUrl(event.index, event.url)
            is RegistrationUiEvent.AddPhotoField -> addPhotoField()
            is RegistrationUiEvent.RemovePhotoField -> removePhotoField(event.index)
            is RegistrationUiEvent.PasswordChanged -> updatePassword(event.password)
            is RegistrationUiEvent.Submit -> registerUser()

            is RegistrationUiEvent.EmailFocusChanged -> onEmailFocusChanged(event.hasFocus)
            is RegistrationUiEvent.NameFocusChanged -> onNameFocusChanged(event.hasFocus)
            is RegistrationUiEvent.PasswordFocusChanged -> onPasswordFocusChanged(event.hasFocus)
        }
    }

    private fun onEmailFocusChanged(hasFocus: Boolean) {
        _state.update { currentState ->
            currentState.copy(
                wasEmailFieldFocused =
                    currentState.wasEmailFieldFocused || (currentState.isEmailFocused && !hasFocus),
                isEmailFocused = hasFocus
            )
        }
        validateForm()
    }

    private fun onPasswordFocusChanged(hasFocus: Boolean) {
        _state.update { currentState ->
            currentState.copy(
                wasPasswordFieldFocused = currentState.wasPasswordFieldFocused || (currentState.isPasswordFocused && !hasFocus),
                isPasswordFocused = hasFocus
            )
        }
        validateForm()
    }

    private fun onNameFocusChanged(hasFocus: Boolean) {
        _state.update { currentState ->
            currentState.copy(
                wasNameFieldFocused = currentState.wasNameFieldFocused || (currentState.isNameFocused && !hasFocus),
                isNameFocused = hasFocus
            )
        }
        validateForm()
    }

    private fun updateAbout(about: String) {
        _state.update { it.copy(aboutMe = about) }
    }

    private fun updateBirthday(millis: Long?) {
        _state.update { it.copy(birthDateMillis = millis) }
        validateForm()
    }

    private fun updateGender(gender: String) {
        _state.update { it.copy(gender = gender) }
        validateForm()
    }

    private fun updateSearchGender(gender: String) {
        _state.update { it.copy(searchGender = gender) }
        validateForm()
    }

    private fun updateEmail(email: String) {
        _state.update { it.copy(email = email) }
        validateForm()
    }

    private fun updatePassword(password: String) {
        _state.update { it.copy(password = password) }
        validateForm()
    }

    private fun updateName(name: String) {
        _state.update { it.copy(name = name) }
        validateForm()
    }

    private fun addPhotoField() {
        _state.update { it.copy(photoUrls = it.photoUrls + "") }
        validateForm()
    }

    private fun removePhotoField(index: Int) {
        _state.update { state ->
            val newList = state.photoUrls.toMutableList().apply {
                if (index in indices) removeAt(index)
            }
            state.copy(photoUrls = newList)
        }
        validateForm()
    }

    private fun updatePhotoUrl(index: Int, url: String) {
        if (!url.isEmpty()) {
            _state.update { state ->
                val newList = state.photoUrls.toMutableList().apply {
                    if (index in indices) set(index, url)
                }
                state.copy(photoUrls = newList)
            }
        }
        validateForm()
    }

    private fun validateForm() {
        val currentState = _state.value

        val emailError =
            if (!isEmailValid(currentState.email)) UiTextUtil.StringResourceKmp(Res.string.email_error_text) else null
        val passwordError =
            if (!isPasswordValid(currentState.password)) UiTextUtil.StringResourceKmp(Res.string.password_error_text) else null
        val nameError =
            if (currentState.name.length < 2) UiTextUtil.StringResourceKmp(Res.string.name_error_text) else null

        val isValid = emailError == null &&
                nameError == null &&
                passwordError == null &&
                currentState.gender.isNotBlank() &&
                currentState.searchGender.isNotBlank() &&
                currentState.birthDateMillis != null

        _state.update {
            it.copy(
                emailError = emailError,
                passwordError = passwordError,
                nameError = nameError,
                isFormValid = isValid
            )
        }
    }

    private fun registerUser() {
        // При попытке сабмита — помечаем все поля как "тронутые", чтобы ошибки подсветились
        _state.update {
            it.copy(
                wasNameFieldFocused = true,
                wasEmailFieldFocused = true,
                wasPasswordFieldFocused = true
            )
        }

        validateForm()

        val currentState = _state.value
        if (!currentState.isFormValid) return

        _state.update { it.copy(isLoading = true) }

        viewModelScope.launch(Dispatchers.IO) {
            val result = registerUserUseCase(currentState.toFeatureModel())
            result.onSuccess {
                _state.update { it.copy(isLoading = true) }
                _effect.send(RegistrationEffect.Success)
                //navigationDispatcher.emit(NavigateToLoginScreen(it.userId))
            }.onFailure { error ->
                _state.update { it.copy(isLoading = false) }
                _effect.send(
                    RegistrationEffect.NetworkError(
                        if (error.message.isNullOrEmpty()) {
                            UiTextUtil.StringResourceKmp(Res.string.unknown_error_text)
                        } else {
                            UiTextUtil.DynamicString(error.message.toString())
                        }
                    )
                )
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return email.matches(EMAIL_REGEX_STRING.toRegex())
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.contains(PASSWORD_REGEX_STRING.toRegex())
    }

    companion object {
        private const val PASSWORD_REGEX_STRING =
            "^(?=.*[A-Za-zА-Яа-я])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-zА-Яа-я\\d@$!%*?&]{8,}\$"
        private const val EMAIL_REGEX_STRING =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$"
    }

}
