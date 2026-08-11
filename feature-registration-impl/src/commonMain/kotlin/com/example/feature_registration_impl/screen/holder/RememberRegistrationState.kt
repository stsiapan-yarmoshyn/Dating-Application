package com.example.feature_registration_impl.screen.holder

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.feature_registration_impl.screen.RegistrationState
import com.example.feature_registration_impl.screen.RegistrationViewModel
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberRegistrationState(
    vmState: RegistrationState,
    viewModel: RegistrationViewModel,
): RegistrationScreenState {
    val snackbarHostState = remember { SnackbarHostState() }
    val scrollState = rememberScrollState()
    val datePickerState = rememberDatePickerState()
    val genderStrings = viewModel.genderList.map { stringResource(it) }

    val screenState = rememberSaveable(
        snackbarHostState,
        scrollState,
        datePickerState,
        genderStrings,
        vmState, // Добавляем vmState в ключи для реинициализации при необходимости
        saver = RegistrationScreenState.saver(
            snackbarHostState = snackbarHostState,
            scrollState = scrollState,
            datePickerState = datePickerState,
            vmState = vmState,
            genderStrings = genderStrings,
            onEvent = viewModel::handleIntent
        )
    ) {
        RegistrationScreenState(
            initialName = vmState.name,
            initialEmail = vmState.email,
            initialPassword = vmState.password,
            initialBio = vmState.aboutMe,
            genderStrings = genderStrings,
            initialVmState = vmState,
            snackbarHostState = snackbarHostState,
            scrollState = scrollState,
            datePickerState = datePickerState,
            onEvent = viewModel::handleIntent
        )
    }

    LaunchedEffect(vmState) {
        screenState.updateFromViewModel(vmState)
    }

    return screenState
}
