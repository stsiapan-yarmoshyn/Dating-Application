package com.example.feature_matching_impl.screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.feature_matching_api.model.PhotoModel
import com.example.feature_matching_api.model.UserProfileModel
import com.example.feature_matching_impl.screen.MatchingViewModel
import com.example.feature_matching_impl.util.LightAndDarkPreview
import com.example.feature_matching_impl.screen.ui.card.UserCardView
import com.example.feature_matching_impl.screen.ui.footer.FooterView
import com.example.feature_matching_impl.screen.ui.header.HeaderView

val user = UserProfileModel(
    name = "",
    gender = "",
    email = "",
    password = "",
    bio = "",
    birthDate = 0,
    photos = listOf(
        PhotoModel("https://www.pinterest.com/pin/1112389176725261629/", 0),
        PhotoModel("https://www.pinterest.com/pin/724938871281092307/", 1),
        PhotoModel("https://www.pinterest.com/pin/1040401951444441178/", 2)
    ),
    searchGender = ""
)

@Composable
fun MatchingScreen(
    matchingViewModel: MatchingViewModel = hiltViewModel()
) {
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
            UserCardView(
                user = user,
                onLikeSwipe = {},
                onDislikeSwipe = {},
                onInfoClick = {},
            )
        }

        FooterView(
            onDiscardClick = {},
            onLikeClick = {}
        )
    }
}

@LightAndDarkPreview
@Composable
fun MatchingScreenPreview() {
    MatchingScreen()
}