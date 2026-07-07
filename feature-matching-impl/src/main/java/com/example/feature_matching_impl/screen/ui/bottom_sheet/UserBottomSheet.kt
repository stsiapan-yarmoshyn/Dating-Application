package com.example.feature_matching_impl.screen.ui.bottom_sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.feature_matching_api.model.UserProfileModel

val DarkBg = Color(0xFF111625)
val CardBg = Color(0xFF1A2035)
val PrimaryPink = Color(0xFFE94057)
val TextGray = Color(0xFF9A9EAA)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserBottomSheet(
    user: UserProfileModel,
    bottomSheetState: SheetState,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = bottomSheetState,
        containerColor = DarkBg,
        dragHandle = { BottomSheetDefaults.DragHandle(color = TextGray) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {

            BottomSheetHeader(
                mainText = user.name,
                subtext = "Senior Designer at Figma",
                onDismiss = onDismiss
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                InfoCard(
                    modifier = Modifier.weight(1f),
                    title = "DISTANCE",
                    value = "4 miles away",
                )
                InfoCard(
                    modifier = Modifier.weight(1f),
                    title = "PROFESSION",
                    value = "Senior Designer",
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            AboutMeView(user.bio)

            Spacer(modifier = Modifier.height(24.dp))

            PhotoListView(user.photos)

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}