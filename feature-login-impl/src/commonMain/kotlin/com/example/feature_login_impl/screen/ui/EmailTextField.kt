package com.example.feature_login_impl.screen.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import datingapplication.feature_login_impl.generated.resources.Res
import datingapplication.feature_login_impl.generated.resources.email_field_text
import datingapplication.feature_login_impl.generated.resources.user_icon_description
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmailTextField(
    email: String,
    isLoading: Boolean,
    onUsernameChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = email,
        onValueChange = { onUsernameChange(it) },
        label = { Text(stringResource(Res.string.email_field_text)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = stringResource(Res.string.user_icon_description)
            )
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        enabled = !isLoading
    )
}