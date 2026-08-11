package com.example.feature_login_impl.screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.feature_login_impl.screen.LoginEffect
import com.example.feature_login_impl.screen.LoginEvent
import com.example.feature_login_impl.screen.LoginViewModel
import datingapplication.feature_login_impl.generated.resources.Res
import datingapplication.feature_login_impl.generated.resources.dont_have_account_text
import datingapplication.feature_login_impl.generated.resources.welcome_text
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onNavigateToMatching: () -> Unit,
    onNavigateToRegistration: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val state by loginViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        loginViewModel.effect.collect { effect ->
            when (effect) {
                is LoginEffect.Error -> {
                    val message = effect.message.asStringSuspend()
                    snackbarHostState.showSnackbar(message, actionLabel = "OK")
                }

                is LoginEffect.Success -> {
                    onNavigateToMatching()
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Заголовок экрана
            Text(
                text = stringResource(Res.string.welcome_text),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Поле ввода email
            EmailTextField(state.email, state.isLoading) {
                loginViewModel.handleEvent(LoginEvent.EmailChanged(it))
            }

            Spacer(modifier = Modifier.height(16.dp))

            //Поле ввода пароля
            PasswordTextField(state.password, state.isLoading) {
                loginViewModel.handleEvent(LoginEvent.PasswordChanged(it))
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Кнопка входа с индикатором загрузки
            LoginBtnWithCircularProgress(state.isButtonEnabled, state.isLoading) {
                loginViewModel.handleEvent(LoginEvent.LoginButtonClicked)
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(
                onClick = onNavigateToRegistration
            ) {
                Text(
                    stringResource(Res.string.dont_have_account_text),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}