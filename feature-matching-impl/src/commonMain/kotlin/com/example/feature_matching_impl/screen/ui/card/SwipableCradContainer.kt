package com.example.feature_matching_impl.screen.ui.card

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
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlin.math.abs
import kotlin.math.roundToInt

enum class SwipeDirection {
    Left,
    Center,
    Right
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeableCardContainer(
    actionFlow: SharedFlow<SwipeDirection>,
    onSwipedLeft: () -> Unit,
    onSwipedRight: () -> Unit,
    onSwipeProgress: (Float) -> Unit,
    content: @Composable () -> Unit
) {
    val windowInfo = LocalWindowInfo.current
    val containerWidthPx = windowInfo.containerSize.width.toFloat()
    val dismissThreshold = containerWidthPx * 1.2f

    val currentAnchors = remember(dismissThreshold) {
        DraggableAnchors {
            SwipeDirection.Left at -dismissThreshold
            SwipeDirection.Center at 0f
            SwipeDirection.Right at dismissThreshold
        }
    }

    val swipeState = remember(currentAnchors) {
        AnchoredDraggableState(
            initialValue = SwipeDirection.Center,
            anchors = currentAnchors,
        )
    }

    LaunchedEffect(actionFlow) {
        actionFlow.collect { direction ->
            when (direction) {
                SwipeDirection.Left -> swipeState.animateTo(SwipeDirection.Left, tween(350))
                SwipeDirection.Right -> swipeState.animateTo(SwipeDirection.Right, tween(350))
                else -> {}
            }
        }
    }

    LaunchedEffect(swipeState, containerWidthPx) {
        snapshotFlow { swipeState.offset }
            .distinctUntilChanged()
            .collect { currentOffset ->
                if (containerWidthPx > 0 && !currentOffset.isNaN()) {
                    val progress = abs(currentOffset) / containerWidthPx
                    onSwipeProgress(progress.coerceIn(0f, 1f))
                }
            }
    }

    LaunchedEffect(swipeState.currentValue) {
        when (swipeState.currentValue) {
            SwipeDirection.Left -> onSwipedLeft()
            SwipeDirection.Right -> onSwipedRight()
            SwipeDirection.Center -> {}
        }
    }

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