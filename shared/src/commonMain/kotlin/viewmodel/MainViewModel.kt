package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_database_api.data.usecase.session.ClearSessionUseCase
import com.example.core_database_api.data.usecase.session.GetUserTokenUseCase
import com.example.core_remote_api.usecase.user.CheckTokenValidationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUserTokenUseCase: GetUserTokenUseCase,
    private val clearSessionUseCase: ClearSessionUseCase,
    private val checkTokenValidationUseCase: CheckTokenValidationUseCase
): ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Loading)
    val authState = _authState.asStateFlow()

    init {
        checkSession()
    }

    private fun checkSession() {
        viewModelScope.launch {
            // 1. Проверяем, есть ли токен локально в DataStore
            val token = getUserTokenUseCase()

            if (token.isNullOrBlank()) {
                _authState.value = AuthState.Unauthenticated
                return@launch
            }

            // 2. Токен есть, проверяем его валидность на сервере Backendless
            val isTokenValid = checkTokenValidationUseCase().getOrDefault(false)

            if (isTokenValid) {
                _authState.value = AuthState.Authenticated
            } else {
                // Если токен протух — принудительно чистим сессию
                clearSessionUseCase()
                _authState.value = AuthState.Unauthenticated
            }
        }
    }


}