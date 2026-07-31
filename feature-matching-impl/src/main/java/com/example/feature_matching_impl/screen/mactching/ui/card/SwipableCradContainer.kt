package com.example.feature_matching_impl.screen.mactching.ui.card

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.gestures.animateTo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.IntOffset
import com.example.feature_matching_impl.screen.SwipeDirection
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlin.math.abs
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeableCardContainer(
    swipeState: AnchoredDraggableState<SwipeDirection>,
    containerWidthPx: Float,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .anchoredDraggable(
                state = swipeState,
                orientation = Orientation.Horizontal,
                enabled = true
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .offset {
                    IntOffset(swipeState.requireOffset().roundToInt(), 0)
                }
                .graphicsLayer {
                    val currentOffset = swipeState.requireOffset()
                    val rotationAngle = if (containerWidthPx > 0)
                        (currentOffset / containerWidthPx) * 15f
                    else 0f

                    rotationZ = rotationAngle
                }
        ) {
            content()
        }
    }
}