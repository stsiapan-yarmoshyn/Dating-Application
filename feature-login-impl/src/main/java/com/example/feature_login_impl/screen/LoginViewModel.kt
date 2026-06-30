package com.example.feature_login_impl.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_login_impl.R
import com.example.feature_login_impl.data.usecase.LoginUserUseCase
import com.example.feature_login_impl.data.usecase.SaveUserUseCase
import com.example.feature_login_impl.util.UiTextUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUserUseCase,
    private val saveUserUseCase: SaveUserUseCase
): ViewModel() {
    private val _state = MutableStateFlow(LoginUIState())
    val state = _state.asStateFlow()

    private val _effect = Channel<LoginEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

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
        viewModelScope.launch(Dispatchers.IO) {

            loginUseCase(_state.value.email, _state.value.password).fold(
                onSuccess = { user ->
                    saveUserUseCase(user).fold(
                        onSuccess = {
                            _state.update { it.copy(isLoading = false) }
                            _effect.send(LoginEffect.Success)
                        },
                        onFailure = { localError -> handleLoginError(localError) }
                    )
                },
                onFailure = { remoteError -> handleLoginError(remoteError) }
            )
        }
    }

    private suspend fun handleLoginError(error: Throwable) {
        _state.update { it.copy(isLoading = false) }
        _effect.send(LoginEffect.Error(
            if (error.message.isNullOrEmpty()) {
                UiTextUtil.StringResource(R.string.unknown_error_text)
            } else {
                UiTextUtil.DynamicString(error.message.toString())
            }
        ))
    }

}