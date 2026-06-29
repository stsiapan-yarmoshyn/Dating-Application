package com.example.feature_registration_impl.screen

import android.text.TextUtils
import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_registration_api.model.PhotoModel
import com.example.feature_registration_api.model.UserProfileModel
import com.example.feature_registration_impl.R
import com.example.feature_registration_impl.mapper.toFeatureModel
import com.example.feature_registration_impl.usecase.RegisterUserUseCase
import com.example.feature_registration_impl.util.UiTextUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(RegistrationUiState())
    val state: StateFlow<RegistrationUiState> = _state.asStateFlow()

    fun handleIntent(event: RegistrationUiEvent) {
        when (event) {
            is RegistrationUiEvent.AboutChanged -> {
                _state.update { it.copy(aboutMe = event.about) }
                validateForm()
            }

            RegistrationUiEvent.AddPhotoField -> {
                _state.update { it.copy(photoUrls = it.photoUrls + "") }
                validateForm()
            }

            is RegistrationUiEvent.BirthDateChanged -> {
                _state.update { it.copy(birthDateMillis = event.millis) }
                validateForm()
            }

            is RegistrationUiEvent.EmailChanged -> {
                _state.update { it.copy(email = event.email) }
                validateForm()
            }

            is RegistrationUiEvent.GenderChanged -> {
                _state.update { it.copy(gender = event.gender) }
                validateForm()
            }


            is RegistrationUiEvent.SearchGenderChanged -> {
                _state.update { it.copy(searchGender = event.gender) }
                validateForm()
            }

            is RegistrationUiEvent.NameChanged -> {
                _state.update { it.copy(name = event.name) }
                validateForm()
            }

            is RegistrationUiEvent.PhotoUrlChanged -> {
                _state.update { state ->
                    val newList =
                        state.photoUrls.toMutableList().apply { set(event.index, event.url) }
                    state.copy(photoUrls = newList)
                }
                validateForm()
            }

            is RegistrationUiEvent.RemovePhotoField -> {
                _state.update { state ->
                    val newList = state.photoUrls.toMutableList().apply { removeAt(event.index) }
                    state.copy(photoUrls = newList)
                }
                validateForm()
            }

            is RegistrationUiEvent.PasswordChanged -> {
                _state.update { it.copy(password = event.password) }
                validateForm()
            }

            RegistrationUiEvent.Submit -> {
                registerUser()
            }
        }
    }

    private fun validateForm() {
        val state = _state.value
        val isValid = state.name.isNotBlank() &&
                state.email.contains("@") &&
                state.password.isNotBlank()
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
            //TODO catch result
            registerUserUseCase(state.toFeatureModel())
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