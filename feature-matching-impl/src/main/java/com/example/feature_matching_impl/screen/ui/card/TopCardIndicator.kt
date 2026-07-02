package com.example.feature_matching_impl.screen.ui.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.feature_matching_impl.screen.LightAndDarkPreview

@Composable
fun TopCardIndicator() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(4.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(4.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.4f))
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(4.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.4f))
        )
    }
}

@LightAndDarkPreview
@Composable
fun TopCardPreview(){
    TopCardIndicator()
}