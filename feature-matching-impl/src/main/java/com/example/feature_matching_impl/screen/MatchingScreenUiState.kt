package com.example.feature_matching_impl.screen

import com.example.feature_matching_api.model.UserProfileModel

data class MatchingScreenUiState(
    val users: List<UserProfileModel> = emptyList(),
    val pageOffset: Int = 0,
    val showBottomSheet: Boolean = false,
    val isLoading: Boolean = false,
    val isPageLoading: Boolean = false,
    val error: String? = null
)