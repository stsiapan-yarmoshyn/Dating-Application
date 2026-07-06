package com.example.feature_matching_impl.screen.ui.card.photo

import android.util.Log
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.feature_matching_impl.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PhotoView(
    photoUrl: String,
) {

    val isPreview = LocalInspectionMode.current

    val imageModel = if (isPreview) {
        R.drawable.test1
    } else {
        photoUrl
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        GlideImage(
            model = imageModel,
            contentDescription = "User Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        PhotoGradient()
    }
}