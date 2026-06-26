package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.feature_registration_impl.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    onRegistrationSuccess: () -> Unit,
    onLoginNavigation: () -> Unit,
) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var aboutMe by remember { mutableStateOf("") }

    var selectedGender by remember { mutableStateOf("") }
    var genderToFind by remember { mutableStateOf("") }

    val dateTimePickerState = rememberDatePickerState()
    val photoUrls = remember { mutableStateListOf<String>() }
    val scrollSate = rememberScrollState()

    val isFormValid = name.isNotBlank()
            && email.contains("@")
            && password.length >= 6
            && selectedGender.isNotBlank()
            && dateTimePickerState.selectedDateMillis != null

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
        NameTextField(name) { name = it }

        //Email
        EmailTextField(email) { email = it }

        //Пароль
        PasswordTextField(password) { password = it }

        // О себе (Многострочное поле)
        BioTextField(aboutMe) { aboutMe = it }

        // Дата рождения (Поле-кликер для вызова календаря)
        CalendarView(dateTimePickerState)

        // Пол (Выпадающее меню ExposedDropdownMenuBox)
        GenderDropdownMenu(selectedGender) { selectedGender = it }

        // Пол для поиска(Выпадающее меню ExposedDropdownMenuBox)
        GenderDropdownMenu(genderToFind) { genderToFind = it }

        // Динамический список ссылок на фото
        PhotoListView(photoUrls) { index, url ->
            photoUrls[index] = url
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { if (isFormValid) onRegistrationSuccess() },
            enabled = isFormValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(stringResource(R.string.register_text), style = MaterialTheme.typography.titleMedium)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onLoginNavigation) {
            Text(stringResource(R.string.already_have_account_text), style = MaterialTheme.typography.bodyMedium)
        }


    }

}