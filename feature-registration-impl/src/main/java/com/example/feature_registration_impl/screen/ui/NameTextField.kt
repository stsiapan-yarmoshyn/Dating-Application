package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.feature_registration_impl.R

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
            Text(stringResource(R.string.name_text))
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