package com.example.feature_registration_impl.screen.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.feature_registration_impl.R
import com.example.feature_registration_impl.util.UiTextUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderDropdownMenu(
    selectedGender: String,
    genders: List<Int>,
    onGenderChange: (UiTextUtil) -> Unit,
) {
    var isGenderListExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isGenderListExpanded,
        onExpandedChange = { isGenderListExpanded = !isGenderListExpanded },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedGender,
            onValueChange = {

            },
            readOnly = true,
            label = { Text(stringResource(R.string.gender_text)) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isGenderListExpanded) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
        )
        ExposedDropdownMenu(
            expanded = isGenderListExpanded,
            onDismissRequest = { isGenderListExpanded = false }
        ) {
            genders.forEach { gender ->
                DropdownMenuItem(
                    text = { Text(stringResource(gender)) },
                    onClick = {
                        onGenderChange(UiTextUtil.StringResource(gender))
                        isGenderListExpanded = false
                    }
                )
            }
        }
    }

    Spacer(modifier = Modifier.padding(16.dp))

}