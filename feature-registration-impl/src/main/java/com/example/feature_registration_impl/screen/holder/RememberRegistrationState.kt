package com.example.feature_registration_impl.screen.holder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.feature_registration_impl.screen.RegistrationUiState
import com.example.feature_registration_impl.screen.RegistrationViewModel

@Composable
fun rememberRegistrationState(
    viewModel: RegistrationViewModel,
    viewModelState: RegistrationUiState,
) : RegistrationScreenState {

    val screenState = rememberSaveable(
        saver = RegistrationScreenState.saver(viewModel::handleIntent)
    ) {
        RegistrationScreenState(
            initialName = viewModelState.name,
            initialEmail = viewModelState.email,
            initialPassword = viewModelState.password,
            initialBio = viewModelState.aboutMe,
            onEvent = viewModel::handleIntent
        )
    }

    LaunchedEffect(
        viewModelState.name,
        viewModelState.email,
        viewModelState.password,
        viewModelState.aboutMe
    ) {
        screenState.updateFromViewModel(
            newName = viewModelState.name,
            newEmail = viewModelState.email,
            newPassword = viewModelState.password,
            newBio = viewModelState.aboutMe
        )
    }

    return screenState
}