package com.example.feature_matching_impl.screen.bottomsheet

import com.example.feature_matching_api.model.PhotoModel

data class BottomSheetState(
    val userName: String = "",
    val userBio: String = "",
    val userPhotos: List<PhotoModel> = emptyList(),
    val isBottomSheetOpen: Boolean = false,
)
