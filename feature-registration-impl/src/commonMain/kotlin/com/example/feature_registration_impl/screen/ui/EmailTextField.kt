package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import datingapplication.feature_registration_impl.generated.resources.Res
import datingapplication.feature_registration_impl.generated.resources.email_text
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmailTextField(
    email: String,
    emailError: String? = null,
    onEmailChange: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text(stringResource(Res.string.email_text)) },
            singleLine = true,
            isError = !emailError.isNullOrEmpty(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().onFocusChanged {
                onFocusChanged(it.hasFocus)
            }
        )
        if (!emailError.isNullOrEmpty()) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = emailError,
                color = Color.Red
            )
        }
    }
}