package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import datingapplication.feature_registration_impl.generated.resources.Res
import datingapplication.feature_registration_impl.generated.resources.about_text
import org.jetbrains.compose.resources.stringResource

@Composable
fun BioTextField(
    aboutMe: String,
    onBioChange: (String) -> Unit,
) {

    OutlinedTextField(
        value = aboutMe,
        onValueChange = onBioChange,
        label = { Text(stringResource(Res.string.about_text)) },
        minLines = 3,
        maxLines = 5,
        modifier = Modifier.fillMaxWidth()
    )
}