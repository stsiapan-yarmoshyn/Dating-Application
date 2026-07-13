package com.example.feature_matching_impl.screen.mactching.ui.card.top

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.feature_matching_impl.util.LightAndDarkPreview

@Composable
fun TopCardIndicator(
    currentImageIndex: Int = 0,
    photoSize: Int
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(photoSize) { index ->

            val isSelected = index == currentImageIndex

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(4.dp)
                    .clip(CircleShape)
                    .background(
                        if (isSelected)
                            Color.White
                        else
                            Color.White.copy(alpha = 0.4f)
                    )
            ){}
        }
    }
}

@LightAndDarkPreview
@Composable
fun TopCardPreview(){
    TopCardIndicator(
        photoSize = 5
    )
}