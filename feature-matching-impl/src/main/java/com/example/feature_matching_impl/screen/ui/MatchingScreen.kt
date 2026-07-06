package com.example.feature_matching_impl.screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.feature_matching_api.model.UserProfileModel
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
    photos = emptyList(),
    searchGender = ""
)

@Composable
fun MatchingScreen(

) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HeaderView(
            onChatClick = {},
            onProfileClick = {},
            onMatchingClick = {}
        )

        UserCardView(
            user = user,
            onLikeSwipe = {},
            onDislikeSwipe = {},
            onInfoClick = {},
            onCardClick = {}
        )

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