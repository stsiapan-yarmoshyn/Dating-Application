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
fun BioTextField(
    aboutMe: String,
    onBioChange: (String) -> Unit,
) {

    OutlinedTextField(
        value = aboutMe,
        onValueChange = onBioChange,
        label = { Text(stringResource(R.string.about_text)) },
        minLines = 3,
        maxLines = 5,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.padding(16.dp))

}