package com.example.feature_matching_impl.screen.ui.header

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.feature_matching_impl.screen.LightAndDarkPreview

@Composable
fun HeaderView(
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    onMatchingClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color(0xFF0F111A)) // Темный фон панели
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 1. Левая кнопка: Иконка профиля
        Icon(
            imageVector = Icons.Outlined.Home,
            contentDescription = "Profile",
            tint = Color(0xFF868D9A), // Серый цвет неактивной иконки
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .clickable { onProfileClick() }
        )

        // 2. Центральная кнопка: Четырехконечная звезда (Искра)
        Icon(
            imageVector = Icons.Outlined.Person,
            contentDescription = "Spark",
            tint = Color(0xFF868D9A), // Серый цвет неактивной иконки
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .clickable { onProfileClick() }
        )

        // 3. Правая кнопка: Иконка чата с полупрозрачным фоном
        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = "Chat",
            tint = Color(0xFF868D9A), // Серый цвет неактивной иконки
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .clickable { onProfileClick() }
        )
    }
}

@LightAndDarkPreview
@Composable
fun HeaderPreview() {
    HeaderView(
        onChatClick = {},
        onProfileClick = {},
        onMatchingClick = {}
    )
}