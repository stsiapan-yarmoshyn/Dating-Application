package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.feature_registration_impl.R

@Composable
fun PhotoListView(
    photoUrls: List<String>,
    onPhotoUrlChanged: (Int, String) -> Unit,
    onPhotoRemoved: (Int) -> Unit,
    onNewFiledAdded: () -> Unit
) {
    Column() {
        Text(
            text = stringResource(R.string.photo_list_text),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.align(Alignment.Start)
        )

        photoUrls.forEachIndexed { index, url ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = url,
                    onValueChange = { onPhotoUrlChanged(index, it) },
                    label = { Text("${stringResource(R.string.photo_link_text)}${index + 1}") },
                    singleLine = true,
                    modifier = Modifier.weight(1f)
                )
                if (photoUrls.size > 1) {
                    IconButton(onClick = { onPhotoRemoved(index) }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_delete),
                            contentDescription = stringResource(R.string.delete_link_field_text)
                        )
                    }
                }
            }
        }

        // Кнопка добавления еще одного поля для фото
        TextButton(
            onClick = { onNewFiledAdded() },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(painter = painterResource(R.drawable.ic_add), contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text(stringResource(R.string.add_link_text))
        }

        Spacer(modifier = Modifier.height(16.dp))

    }

}