package com.example.feature_matching_impl.screen.ui.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.feature_matching_impl.R
import com.example.feature_matching_impl.screen.LightAndDarkPreview

@Composable
fun PhotoView() {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.test2),
            contentDescription = "User Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        //градиент
        PhotoGradient()

    }
}