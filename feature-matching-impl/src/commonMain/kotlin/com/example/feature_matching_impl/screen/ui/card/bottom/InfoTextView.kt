package com.example.feature_matching_impl.screen.ui.card.bottom

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoTextView(
    leadingText: String? = null,
    leadingIcon: ImageVector? = null,
    baseText: String,
    baseTextSize: Int = 16,
    leadingTextSize: Int = 32
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!leadingText.isNullOrEmpty()) {
            Text(
                text = leadingText,
                color = Color.White,
                fontSize = leadingTextSize.sp,
                fontWeight = FontWeight.Bold
            )
        }
        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "leadingIcon",
                tint = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.size(16.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = baseText,
            color = Color.White,
            fontSize = baseTextSize.sp,
            fontWeight = FontWeight.Normal
        )
    }

    Spacer(modifier = Modifier.height(8.dp))
}

