package com.example.feature_matching_impl.screen.ui.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.feature_matching_api.model.UserProfileModel
import com.example.feature_matching_impl.util.LightAndDarkPreview
import com.example.feature_matching_impl.screen.ui.card.bottom.BottomInfoView
import com.example.feature_matching_impl.screen.ui.card.photo.PhotoView
import com.example.feature_matching_impl.screen.ui.card.top.TopCardIndicator


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
fun UserCardView(
    user: UserProfileModel,
    onLikeSwipe: () -> Unit,
    onDislikeSwipe: () -> Unit,
    onInfoClick: () -> Unit,
    onCardClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.7f)
            .clip(RoundedCornerShape(32.dp))
            .background(Color.Black)
    ) {
        PhotoView()

        TopCardIndicator()

        BottomInfoView(
            modifier = Modifier.align(Alignment.BottomEnd)
        ) { }
    }
}

@LightAndDarkPreview
@Composable
fun UserCardPreview() {
    UserCardView(
        user = user,
        onLikeSwipe = {},
        onDislikeSwipe = {},
        onInfoClick = {},
        onCardClick = {}
    )
}