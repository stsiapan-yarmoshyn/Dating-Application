package com.example.feature_matching_impl.screen.ui.bottom_sheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomSheetHeader(
    mainText: String,
    subtext: String,
    onDismiss: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = mainText, color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text(text = subtext, color = TextGray, fontSize = 16.sp)
        }
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",

            modifier = Modifier
                .size(32.dp)
                .clickable {
                    onDismiss()
                },
            tint = Color.White
        )
    }
}