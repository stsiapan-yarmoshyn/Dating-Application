package com.example.feature_login_impl.screen.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.feature_login_impl.R

@Composable
fun LoginBtnWithCircularProgress(
    isButtonEnabled: Boolean,
    isLoading: Boolean,
    onLoginSuccess: () -> Unit
) {
    Button(
        onClick = {
            onLoginSuccess()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = isButtonEnabled && !isLoading
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                strokeWidth = 2.dp
            )
        } else {
            Text(
                stringResource(R.string.enter_btn_text),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}