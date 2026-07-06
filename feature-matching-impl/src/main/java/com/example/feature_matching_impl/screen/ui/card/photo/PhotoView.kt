package com.example.feature_matching_impl.screen.ui.card.photo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.feature_matching_impl.R

@Composable
fun PhotoView() {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.test2),
            contentDescription = "User Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        PhotoGradient()
    }
}