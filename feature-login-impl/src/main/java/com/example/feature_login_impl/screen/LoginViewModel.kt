package com.example.feature_login_impl.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow(LoginUIState())
    val state = _state.asStateFlow()

    fun handleEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.EmailChanged -> {
                _state.update { it.copy(email = event.email) }
                turnOnButton()
            }
            is LoginEvent.PasswordChanged -> {
                _state.update { it.copy(password = event.password) }
                turnOnButton()
            }
            LoginEvent.LoginButtonClicked -> {
                logIn()
            }
        }
    }


    private fun turnOnButton() {
        val isButtonEnabled = _state.value.email.isNotBlank() && _state.value.password.length >= 6
        _state.update { it.copy(isButtonEnabled = isButtonEnabled) }
    }

    private fun logIn() {
        _state.update { it.copy(isLoading = true) }
    }

}