package com.example.feature_matching_impl.screen.mactching

import com.example.feature_matching_api.model.UserProfileModel

data class MatchingScreenUiState(
    val users: List<UserProfileModel> = emptyList(),
    val pageOffset: Int = 0,
    val isLoading: Boolean = false,
    val isPageLoading: Boolean = false,
    val error: String? = null
)