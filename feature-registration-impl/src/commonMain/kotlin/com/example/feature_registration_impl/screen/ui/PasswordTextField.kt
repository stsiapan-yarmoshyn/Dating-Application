package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import datingapplication.feature_registration_impl.generated.resources.Res
import datingapplication.feature_registration_impl.generated.resources.ic_visibility
import datingapplication.feature_registration_impl.generated.resources.ic_visibility_off
import datingapplication.feature_registration_impl.generated.resources.password_hide_text
import datingapplication.feature_registration_impl.generated.resources.password_show_text
import datingapplication.feature_registration_impl.generated.resources.password_text
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun PasswordTextField(
    password: String,
    passwordError: String? = null,
    onPasswordChange: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
) {

    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text(stringResource(Res.string.password_text)) },
            singleLine = true,
            isError = !passwordError.isNullOrEmpty(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible) {
                    painterResource(Res.drawable.ic_visibility)
                } else {
                    painterResource(Res.drawable.ic_visibility_off)
                }
                val description =
                    if (passwordVisible) {
                        stringResource(Res.string.password_hide_text)
                    } else {
                        stringResource(Res.string.password_show_text)
                    }

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = image, contentDescription = description)
                }
            },
            modifier = Modifier.fillMaxWidth().onFocusChanged {
                onFocusChanged(it.hasFocus)
            }
        )
        if (!passwordError.isNullOrEmpty()) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = passwordError,
                color = Color.Red
            )
        }
    }
}