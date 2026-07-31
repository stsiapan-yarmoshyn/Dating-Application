package com.example.feature_matching_impl.screen.mactching.ui.footer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FooterView(
    modifier: Modifier = Modifier,
    onDiscardClick: () -> Unit,
    onLikeClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleButton(
            icon = Icons.Default.Clear,
            iconColor = Color(0xFFE91E63),
            borderColor = Color(0xFFE91E63).copy(alpha = 0.3f),
            size = 76.dp,
            iconSize = 36.dp,
            onClick = onDiscardClick
        )

        Spacer(modifier = Modifier.width(32.dp))

        CircleButton(
            icon = Icons.Default.Favorite,
            iconColor = Color(0xFF00E676),
            borderColor = Color(0xFF00E676).copy(alpha = 0.3f),
            size = 76.dp,
            iconSize = 34.dp,
            onClick = onLikeClick
        )
    }

}

@Composable
fun FooterPreview() {
    FooterView(
        onDiscardClick = {},
        onLikeClick = {}
    )
}