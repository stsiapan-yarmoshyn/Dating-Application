package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.feature_registration_impl.R
import com.example.feature_registration_impl.screen.RegistrationEffect
import com.example.feature_registration_impl.screen.RegistrationUiEvent
import com.example.feature_registration_impl.screen.RegistrationViewModel
import com.example.feature_registration_impl.screen.holder.rememberRegistrationState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    registrationViewModel: RegistrationViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val state by registrationViewModel.state.collectAsStateWithLifecycle()
    val uiState = rememberRegistrationState(registrationViewModel, state)
    val scrollSate = rememberScrollState()
    val dateTimePickerState = rememberDatePickerState()

    LaunchedEffect(Unit) {
        registrationViewModel.effect.collect { effect ->
            when (effect) {
                is RegistrationEffect.NetworkError -> {
                    val message = effect.message.asString(context)
                    snackbarHostState.showSnackbar(message, actionLabel = "OK")
                }

                is RegistrationEffect.Success -> {
                    //TODO -> add navigation
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
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
                    .verticalScroll(scrollSate),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.register_header_text),
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                //Имя
                NameTextField(uiState.name, state.nameError?.asString()) {
                    uiState.onNameChanged(it)
                }

                //Email
                EmailTextField(state.email, state.emailError?.asString()) {
                    uiState.onEmailChanged(it)
                }

                //Пароль
                PasswordTextField(state.password, state.passwordError?.asString()) {
                    uiState.onPasswordChanged(it)
                }

                // О себе (Многострочное поле)
                BioTextField(state.aboutMe) {
                    uiState.onBioChanged(it)
                }

                // Дата рождения (Поле-кликер для вызова календаря)
                CalendarView(dateTimePickerState) {
                    registrationViewModel.handleIntent(
                        RegistrationUiEvent.BirthDateChanged(it)
                    )
                }

                // Пол (Выпадающее меню ExposedDropdownMenuBox)
                GenderDropdownMenu(state.gender, registrationViewModel.genderList) {
                    registrationViewModel.handleIntent(
                        RegistrationUiEvent.GenderChanged(it.asString(context))
                    )
                }

                // Пол для поиска(Выпадающее меню ExposedDropdownMenuBox)
                GenderDropdownMenu(state.searchGender, registrationViewModel.genderList) {
                    registrationViewModel.handleIntent(
                        RegistrationUiEvent.SearchGenderChanged(it.asString(context))
                    )
                }

                // Динамический список ссылок на фото
                PhotoListView(
                    state.photoUrls,
                    onPhotoUrlChanged = { index, url ->
                        registrationViewModel.handleIntent(
                            RegistrationUiEvent.PhotoUrlChanged(index, url)
                        )
                    },
                    onPhotoRemoved = { index ->
                        registrationViewModel.handleIntent(
                            RegistrationUiEvent.RemovePhotoField(index)
                        )
                    },
                    onNewFiledAdded = { registrationViewModel.handleIntent(RegistrationUiEvent.AddPhotoField) }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (state.isFormValid) {
                            registrationViewModel.handleIntent(RegistrationUiEvent.Submit)
                        }
                    },
                    enabled = state.isFormValid,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        stringResource(R.string.register_text),
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextButton(onClick = {}/*onLoginNavigation*/) {
                    Text(
                        stringResource(R.string.already_have_account_text),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            LoadingOverlay(
                isLoading = state.isLoading,
                modifier = Modifier.align(Alignment.Center)
            )

        }


    }

}