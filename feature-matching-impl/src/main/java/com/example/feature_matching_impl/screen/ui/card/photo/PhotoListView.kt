package com.example.feature_matching_impl.screen.ui.card.photo

import android.util.Log
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.feature_matching_api.model.PhotoModel

@Composable
fun PhotoListView(
    photoList: List<PhotoModel>,
    currentImageIndex: Int,
    onLeftSideCardClick: () -> Unit,
    onRightSideCardClick: () -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { photoList.size })

    LaunchedEffect(currentImageIndex) {
        if (pagerState.currentPage != currentImageIndex) {
            pagerState.animateScrollToPage(currentImageIndex)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    val halfWidth = size.width / 2

                    if (offset.x < halfWidth) {
                        onLeftSideCardClick()
                    } else {
                        onRightSideCardClick()
                    }
                }
            }
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = false
        ) { page ->
            PhotoView(photoList[page].photoUrl)
        }
    }
}