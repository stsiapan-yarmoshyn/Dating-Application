package com.example.feature_matching_impl.screen.ui.card.photo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import coil3.compose.AsyncImage
import datingapplication.feature_matching_impl.generated.resources.Res
import datingapplication.feature_matching_impl.generated.resources.test1


@Composable
fun PhotoView(
    photoUrl: String,
) {
    val isPreview = LocalInspectionMode.current

    val imageModel: Any = if (isPreview || photoUrl.isEmpty()) {
        Res.drawable.test1
    } else {
        photoUrl
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = imageModel,
            contentDescription = "User Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        PhotoGradient()
    }
}