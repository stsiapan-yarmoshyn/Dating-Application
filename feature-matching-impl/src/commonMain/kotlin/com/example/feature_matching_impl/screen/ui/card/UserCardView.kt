package com.example.feature_matching_impl.screen.ui.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.feature_matching_api.model.UserProfileModel
import com.example.feature_matching_impl.screen.ui.card.bottom.BottomInfoView
import com.example.feature_matching_impl.screen.ui.card.photo.PhotoListView
import com.example.feature_matching_impl.screen.ui.card.top.TopCardIndicator

@Composable
fun UserCardView(
    user: UserProfileModel,
    onInfoClick: () -> Unit,
) {

    var imageIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(Color.Black)
    ) {

        PhotoListView(
            photoList = user.photos,
            currentImageIndex = imageIndex,
            onLeftSideCardClick = {
                if (imageIndex > 0) {
                    imageIndex -= 1
                }
            },
            onRightSideCardClick = {
                if (imageIndex < user.photos.size - 1) {
                    imageIndex += 1
                }
            }
        )

        TopCardIndicator(
            currentImageIndex = imageIndex,
            photoSize = user.photos.size
        )

        BottomInfoView(
            user = user,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            onInfoClick()
        }
    }
}