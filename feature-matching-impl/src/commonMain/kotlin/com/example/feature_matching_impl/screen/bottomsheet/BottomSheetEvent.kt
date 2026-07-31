package com.example.feature_matching_impl.screen.bottomsheet

sealed interface BottomSheetEvent {

    data object OnCloseBottomSheet: BottomSheetEvent

    data object OnShowBottomSheet: BottomSheetEvent

    data class ShowUserData(val userId: String): BottomSheetEvent

}