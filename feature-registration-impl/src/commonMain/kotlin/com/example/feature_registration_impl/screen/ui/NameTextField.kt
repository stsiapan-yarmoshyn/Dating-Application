package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import datingapplication.feature_registration_impl.generated.resources.Res
import datingapplication.feature_registration_impl.generated.resources.name_text
import org.jetbrains.compose.resources.stringResource

@Composable
fun NameTextField(
    name: String,
    nameError: String? = null,
    onNameChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        label = {
            Text(stringResource(Res.string.name_text))
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
    )
    if (!nameError.isNullOrEmpty()) {
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = nameError,
        )
    }

    Spacer(modifier = Modifier.padding(16.dp))
}