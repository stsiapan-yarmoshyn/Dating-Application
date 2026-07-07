package com.example.feature_matching_impl.screen.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.feature_matching_api.model.PhotoModel
import com.example.feature_matching_api.model.UserProfileModel
import com.example.feature_matching_impl.screen.ui.bottom_sheet.UserBottomSheet
import com.example.feature_matching_impl.screen.ui.card.SwipeableCardContainer
import com.example.feature_matching_impl.util.LightAndDarkPreview
import com.example.feature_matching_impl.screen.ui.card.UserCardView
import com.example.feature_matching_impl.screen.ui.footer.FooterView
import com.example.feature_matching_impl.screen.ui.header.HeaderView
import kotlinx.coroutines.launch

val user = UserProfileModel(
    name = "Sarah, 24",
    gender = "",
    email = "sara@fff",
    password = "",
    bio = "UI/UX Designer who runs on iced matchas and design deadlines. When I am not pushing pixels, I am exploring hiking trails or cataloging thrift stores.",
    birthDate = 0,
    photos = listOf(
        PhotoModel("", 0),
        PhotoModel("", 1),
        PhotoModel("", 2)
    ),
    searchGender = ""
)

val user2 = UserProfileModel(
    name = "Maks, 24",
    gender = "",
    email = "Maks@ggg",
    password = "",
    bio = "When I am not pushing pixels, I am exploring hiking trails or cataloging thrift stores.",
    birthDate = 0,
    photos = listOf(
        PhotoModel("", 0),
        PhotoModel("", 1),
        PhotoModel("", 2)
    ),
    searchGender = ""
)

val user3 = UserProfileModel(
    name = "Eugene, 24",
    gender = "",
    email = "Eugene@jjj",
    password = "",
    bio = "Test test test tes.",
    birthDate = 0,
    photos = listOf(
        PhotoModel("", 0),
        PhotoModel("", 1),
        PhotoModel("", 2)
    ),
    searchGender = ""
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchingScreen(
    //matchingViewModel: MatchingViewModel = hiltViewModel()
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    val scope = rememberCoroutineScope()

    var swipeProgress by remember { mutableFloatStateOf(0f) }

    val userList = remember {
        mutableStateListOf(user, user2, user3)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        HeaderView(
            onChatClick = {},
            onProfileClick = {},
            onMatchingClick = {}
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (userList.isNotEmpty()) {

                if (userList.size > 1) {
                    val nextUser = userList[1]

                    val targetScale = 0.9f + (swipeProgress * 0.1f)
                    val targetAlpha = 0.5f + (swipeProgress * 0.5f)

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .graphicsLayer {
                                scaleX = targetScale
                                scaleY = targetScale
                                alpha = targetAlpha
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        UserCardView(
                            user = nextUser,
                            onInfoClick = {
                                showBottomSheet = true
                            },
                        )
                    }
                }

                val currentUser = userList.first()

                key(currentUser.email) {
                    SwipeableCardContainer(
                        currentUserId = currentUser.email,
                        onSwipeProgress = { progress ->
                            swipeProgress = progress
                        },
                        onSwipedLeft = {
                            userList.remove(currentUser)
                        },
                        onSwipedRight = {
                            userList.remove(currentUser)
                        }
                    ) {
                        UserCardView(
                            user = currentUser,
                            onInfoClick = {
                                showBottomSheet = true
                            },
                        )
                    }
                }
            } else {
                Text(text = "Карточки закончились! 😔")
            }
        }

        FooterView(
            onDiscardClick = {},
            onLikeClick = {}
        )

        if (showBottomSheet) {
            UserBottomSheet(
                user = user,
                bottomSheetState = sheetState,
                onDismiss = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                    }
                }
            )
        }
    }
}

@LightAndDarkPreview
@Composable
fun MatchingScreenPreview() {
    MatchingScreen()
}