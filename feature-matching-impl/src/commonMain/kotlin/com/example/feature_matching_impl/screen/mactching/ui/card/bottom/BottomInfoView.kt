package com.example.feature_matching_impl.screen.mactching.ui.card.bottom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.feature_matching_api.model.UserProfileModel

@Composable
fun BottomInfoView(
    modifier: Modifier,
    user: UserProfileModel,
    onInfoClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {

            InfoTextView(
                leadingText = user.name,
                baseText = "",
                baseTextSize = 28
            )

            InfoTextView(
                leadingIcon = Icons.Default.Info,
                baseText = "Senior Designer at Figma"
            )

            InfoTextView(
                leadingIcon = Icons.Default.LocationOn,
                baseText = "4 miles away"
            )
        }
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Info",
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.Top)
                .clickable {
                    onInfoClick()
                },
            tint = Color.White.copy(alpha = 0.8f),
        )
    }
}