package com.example.feature_matching_impl.screen.ui.card

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.feature_matching_api.model.PhotoModel
import com.example.feature_matching_api.model.UserProfileModel
import com.example.feature_matching_impl.util.LightAndDarkPreview
import com.example.feature_matching_impl.screen.ui.card.bottom.BottomInfoView
import com.example.feature_matching_impl.screen.ui.card.photo.PhotoGradient
import com.example.feature_matching_impl.screen.ui.card.photo.PhotoListView
import com.example.feature_matching_impl.screen.ui.card.photo.PhotoView
import com.example.feature_matching_impl.screen.ui.card.top.TopCardIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserCardView(
    user: UserProfileModel,
    onInfoClick: () -> Unit,
) {

    var imageIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(0.7f)
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

@LightAndDarkPreview
@Composable
fun UserCardPreview() {
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


    UserCardView(
        user = user,
        onInfoClick = {

        },
    )
}