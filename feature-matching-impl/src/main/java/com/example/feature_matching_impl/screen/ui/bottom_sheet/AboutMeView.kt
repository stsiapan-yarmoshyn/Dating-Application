package com.example.feature_matching_impl.screen.ui.bottom_sheet

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutMeView(
    text: String
) {
    Text(text = "ABOUT ME", color = TextGray, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = text,
        color = Color.White,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
}