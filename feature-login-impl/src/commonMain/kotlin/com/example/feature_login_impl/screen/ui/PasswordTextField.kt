package com.example.feature_login_impl.screen.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import datingapplication.feature_login_impl.generated.resources.Res
import datingapplication.feature_login_impl.generated.resources.ic_visibility
import datingapplication.feature_login_impl.generated.resources.ic_visibility_off
import datingapplication.feature_login_impl.generated.resources.password_field_text
import datingapplication.feature_login_impl.generated.resources.password_hide_text
import datingapplication.feature_login_impl.generated.resources.password_icon_description
import datingapplication.feature_login_impl.generated.resources.password_show_text
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun PasswordTextField(
    password: String,
    isLoading: Boolean,
    onPasswordChange: (String) -> Unit
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { onPasswordChange(it) },
        label = { Text(stringResource(Res.string.password_field_text)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(Res.string.password_icon_description)
            )
        },
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
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        enabled = !isLoading
    )
}