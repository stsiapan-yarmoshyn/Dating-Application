package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import datingapplication.feature_registration_impl.generated.resources.Res
import datingapplication.feature_registration_impl.generated.resources.cancel_text
import datingapplication.feature_registration_impl.generated.resources.date_of_birh_text
import datingapplication.feature_registration_impl.generated.resources.ic_calendar_month
import datingapplication.feature_registration_impl.generated.resources.ok_text
import datingapplication.feature_registration_impl.generated.resources.select_date_text
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarView(
    dateTimePickerState: DatePickerState,
    onDateChanged: (Long?) -> Unit
) {

    var showDatePicker by remember { mutableStateOf(false) }
    val formatDate = remember(dateTimePickerState.selectedDateMillis) {
        dateTimePickerState.selectedDateMillis?.let {
            SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date(it))
        } ?: ""
    }

    OutlinedTextField(
        value = formatDate,
        onValueChange = { onDateChanged(dateTimePickerState.selectedDateMillis) },
        label = { Text(stringResource(Res.string.date_of_birh_text)) },
        readOnly = true,
        trailingIcon = {
            IconButton(onClick = { showDatePicker = true }) {
                Icon(
                    painter = painterResource(Res.drawable.ic_calendar_month),
                    contentDescription = stringResource(Res.string.select_date_text)
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.padding(16.dp))

    // Логика отображения диалога календаря
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text(stringResource(Res.string.ok_text))
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text(stringResource(Res.string.cancel_text))
                }
            }
        ) {
            DatePicker(state = dateTimePickerState)
        }
    }

}