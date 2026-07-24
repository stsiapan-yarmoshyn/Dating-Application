package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.feature_registration_impl.screen.RegistrationEffect
import com.example.feature_registration_impl.screen.RegistrationViewModel
import com.example.feature_registration_impl.screen.holder.rememberRegistrationState
import datingapplication.feature_registration_impl.generated.resources.Res
import datingapplication.feature_registration_impl.generated.resources.already_have_account_text
import datingapplication.feature_registration_impl.generated.resources.register_header_text
import datingapplication.feature_registration_impl.generated.resources.register_text
import org.jetbrains.compose.resources.stringResource
import java.util.logging.Logger

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    registrationViewModel: RegistrationViewModel,
    onNavigateToDetails: (String) -> Unit
) {
    val viewModelState by registrationViewModel.state.collectAsState()
    val uiState = rememberRegistrationState(viewModelState, registrationViewModel)

    LaunchedEffect(Unit) {
        registrationViewModel.effect.collect { effect ->
            when (effect) {
                is RegistrationEffect.NetworkError -> {
                    val message = effect.message.asStringSuspend()
                    uiState.snackbarHostState.showSnackbar(message, actionLabel = "OK") //throw to resources
                }

                is RegistrationEffect.Success -> {
                    uiState.snackbarHostState.showSnackbar("Success") //throw to resources
                    onNavigateToDetails("")
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(uiState.snackbarHostState) }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
                    .verticalScroll(uiState.scrollState),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(Res.string.register_header_text),
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                // Имя
                NameTextField(
                    uiState.name,
                    uiState.nameError?.asString(),
                    onNameChange = { uiState.onNameChanged(it) },
                    onFocusChanged = { uiState.onNameFocusChanged(it) }
                )

                Spacer(modifier = Modifier.padding(16.dp))

                // Email
                EmailTextField(
                    uiState.email,
                    uiState.emailError?.asString(),
                    onEmailChange = { uiState.onEmailChanged(it) },
                    onFocusChanged = { uiState.onEmailFocusChanged(it) }
                )

                Spacer(modifier = Modifier.padding(16.dp))

                // Пароль
                PasswordTextField(
                    uiState.password,
                    uiState.passwordError?.asString(),
                    onPasswordChange = { uiState.onPasswordChanged(it) },
                    onFocusChanged = { uiState.onPasswordFocusChanged(it) }
                )

                Spacer(modifier = Modifier.padding(16.dp))

                // О себе
                BioTextField(uiState.bio) {
                    uiState.onBioChanged(it)
                }

                Spacer(modifier = Modifier.padding(16.dp))

                // Дата рождения
                CalendarView(uiState.datePickerState) {
                    uiState.onBirthDateChanged(it)
                }

                Spacer(modifier = Modifier.padding(16.dp))

                // Пол
                GenderDropdownMenu(uiState.gender, uiState.genderStrings) {
                    uiState.onGenderChanged(it)
                }

                Spacer(modifier = Modifier.padding(16.dp))

                // Пол для поиска
                GenderDropdownMenu(uiState.searchGender, uiState.genderStrings) {
                    uiState.onSearchGenderChanged(it)
                }

                Spacer(modifier = Modifier.padding(16.dp))

                // Список фото
                PhotoListView(
                    uiState.photoUrls,
                    onPhotoUrlChanged = { index, url ->
                        uiState.onPhotoUrlChanged(index, url)
                    },
                    onPhotoRemoved = { index ->
                        uiState.onRemovePhotoField(index)
                    },
                    onNewFiledAdded = { uiState.onAddPhotoField() }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { uiState.onSubmit() },
                    enabled = uiState.isFormValid && !uiState.isLoading,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        stringResource(Res.string.register_text),
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextButton(onClick = {}/*onLoginNavigation*/) {
                    Text(
                        stringResource(Res.string.already_have_account_text),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            LoadingOverlay(
                isLoading = uiState.isLoading,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
