package com.example.feature_matching_impl.screen.mactching.ui

import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.animateTo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.feature_matching_impl.screen.SwipeDirection
import com.example.feature_matching_impl.screen.mactching.MatchingEvent
import com.example.feature_matching_impl.screen.mactching.MatchingViewModel
import com.example.feature_matching_impl.screen.mactching.ui.card.SwipeableCardContainer
import com.example.feature_matching_impl.screen.mactching.ui.card.UserCardView
import com.example.feature_matching_impl.screen.mactching.ui.footer.FooterView
import com.example.feature_matching_impl.screen.mactching.ui.header.HeaderView
import kotlinx.coroutines.flow.filter
import kotlin.math.abs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchingScreen(
    matchingViewModel: MatchingViewModel,
    navigateToDetails: (String) -> Unit,
    navigateToChat: (String) -> Unit,
    navigateToProfile: (String) -> Unit,
    navigateToMatching: () -> Unit,
) {
    val state by matchingViewModel.state.collectAsStateWithLifecycle()
    val containerWidthPx = LocalWindowInfo.current.containerSize.width.toFloat()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        HeaderView(
            onChatClick = {
                navigateToChat
            },
            onProfileClick = {
                navigateToProfile
            },
            onMatchingClick = {
                navigateToMatching
            }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (state.users.isNotEmpty()) {
                val dismissThreshold = containerWidthPx * 1.2f

                val currentAnchors = remember(dismissThreshold) {
                    DraggableAnchors {
                        SwipeDirection.Left at -dismissThreshold
                        SwipeDirection.Center at 0f
                        SwipeDirection.Right at dismissThreshold
                    }
                }

                val currentUser = state.users.first()

                val swipeState = remember(currentUser.email, currentAnchors) {
                    AnchoredDraggableState(
                        initialValue = SwipeDirection.Center,
                        anchors = currentAnchors,
                    )
                }

                LaunchedEffect(Unit) {
                    matchingViewModel.effect
                        .filter { it != SwipeDirection.Center }
                        .collect { direction ->
                            swipeState.animateTo(direction)
                    }
                }

                LaunchedEffect(swipeState.currentValue) {
                    //убрать проверку, заливать во вью сразу свайп дирекшн и проверять в вьюмодел уже
                    if (swipeState.currentValue == SwipeDirection.Right) {
                        matchingViewModel.handleEvent(MatchingEvent.HandleUser(currentUser, true))
                    } else if (swipeState.currentValue == SwipeDirection.Left) {
                        matchingViewModel.handleEvent(MatchingEvent.HandleUser(currentUser, false))
                    }
                }

                if (state.users.size > 1) {
                    val nextUser = state.users[1]
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .graphicsLayer {
                                val offset =
                                    if (swipeState.offset.isNaN()) 0f else swipeState.offset
                                val progress = (abs(offset) / containerWidthPx).coerceIn(0f, 1f)

                                val targetScale = 0.9f + (progress * 0.1f)
                                val targetAlpha = 0.5f + (progress * 0.5f)

                                scaleX = targetScale
                                scaleY = targetScale
                                alpha = targetAlpha
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        UserCardView(
                            user = nextUser,
                            onInfoClick = { userId ->
                                navigateToDetails(userId)
                            },
                        )
                    }
                }

                key(currentUser.email) {
                    SwipeableCardContainer(
                        swipeState = swipeState,
                        containerWidthPx = containerWidthPx
                    ) {
                        UserCardView(
                            user = currentUser,
                            onInfoClick = { userId ->
                                navigateToDetails(userId)
                            },
                        )
                    }
                }
            } else {
                Text(
                    text = "Карточки закончились!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }

        FooterView(
            onDiscardClick = {
                matchingViewModel.handleEvent(MatchingEvent.OnSwipeLeft)
            },
            onLikeClick = {
                matchingViewModel.handleEvent(MatchingEvent.OnSwipeRight)
            }
        )
    }
}