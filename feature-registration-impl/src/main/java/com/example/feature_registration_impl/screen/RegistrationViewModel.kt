package com.example.feature_registration_impl.screen

import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_registration_impl.R
import com.example.feature_registration_impl.data.mapper.toFeatureModel
import com.example.feature_registration_impl.data.usecase.RegisterUserUseCase
import com.example.feature_registration_impl.util.UiTextUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(RegistrationUiState())
    val state: StateFlow<RegistrationUiState> = _state.asStateFlow()

    private val _effect = Channel<RegistrationEffect>()
    val effect = _effect.receiveAsFlow()

    val genderList: List<Int> = listOf(
        R.string.gender_male_text,
        R.string.gender_female_text,
        R.string.gender_other_text
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
        }
    }

    private fun updateAbout(about: String) {
        _state.update { it.copy(aboutMe = about) }
        validateForm()
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
            val newList = state.photoUrls.toMutableList().apply { removeAt(index) }
            state.copy(photoUrls = newList)
        }
        validateForm()
    }

    private fun updatePhotoUrl(index: Int, url: String) {
        _state.update { state ->
            val newList =
                state.photoUrls.toMutableList().apply { set(index, url) }
            state.copy(photoUrls = newList)
        }
        validateForm()
    }

    private fun validateForm() {
        val state = _state.value
        val isValid = state.name.isNotBlank() &&
                state.email.contains("@") &&
                state.password.isNotBlank() &&
                state.gender.isNotBlank() &&
                state.searchGender.isNotBlank() &&
                state.birthDateMillis != null

        _state.update { it.copy(isFormValid = isValid) }
    }

    private fun registerUser() {

        val state = _state.value
        var hasError = false

        if (state.name.length < 2) {
            _state.update { it.copy(nameError = UiTextUtil.StringResource(R.string.name_error_text)) }
            hasError = true
        }
        if (!isEmailValid(state.email)) {
            _state.update { it.copy(emailError = UiTextUtil.StringResource(R.string.email_error_text)) }
            hasError = true
        }
        if (!isPasswordValid(state.password)) {
            _state.update { it.copy(passwordError = UiTextUtil.StringResource(R.string.password_error_text)) }
            hasError = true
        }

        if (hasError) return
        _state.update { it.copy(isLoading = true) }

        viewModelScope.launch(Dispatchers.IO) {
            val result = registerUserUseCase(state.toFeatureModel())
            result.onSuccess {
                _effect.send(RegistrationEffect.Success)
            }.onFailure { error ->
                _effect.send(
                    RegistrationEffect.NetworkError(
                        if (error.message.isNullOrEmpty()) {
                            UiTextUtil.StringResource(R.string.unknown_error_text)
                        } else {
                            UiTextUtil.DynamicString(error.message.toString())
                        }
                    )
                )
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.contains(Regex(PASSWORD_REGEX_STRING))
    }

    companion object {
        private const val PASSWORD_REGEX_STRING =
            "^(?=.*[A-Za-zА-Яа-я])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-zА-Яа-я\\d@\$!%*?&]{8,}\$"
    }

}