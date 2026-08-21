package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import datingapplication.feature_registration_impl.generated.resources.Res
import datingapplication.feature_registration_impl.generated.resources.name_text
import org.jetbrains.compose.resources.stringResource

@Composable
fun NameTextField(
    name: String,
    nameError: String? = null,
    onNameChange: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = {
                Text(stringResource(Res.string.name_text))
            },
            singleLine = true,
            isError = !nameError.isNullOrEmpty(),
            modifier = Modifier.fillMaxWidth().onFocusChanged {
                onFocusChanged(it.hasFocus)
            },
        )
        if (!nameError.isNullOrEmpty()) {
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = nameError,
                color = Color.Red
            )
        }
    }
}