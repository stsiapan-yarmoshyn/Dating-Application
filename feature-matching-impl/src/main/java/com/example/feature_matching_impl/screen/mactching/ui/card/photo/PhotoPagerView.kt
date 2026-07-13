package com.example.feature_matching_impl.screen.mactching.ui.card.photo

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
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