package com.example.feature_matching_impl.screen

import com.example.feature_matching_api.model.UserProfileModel

sealed interface MatchingEvent {
    data object LoadNextPage: MatchingEvent

    data object OnSwipeLeft: MatchingEvent

    data object OnSwipeRight: MatchingEvent

    data class OnInfoClick(val showBottomSheet: Boolean): MatchingEvent

    data class HandleUser(val currentUser: UserProfileModel, val isLiked: Boolean): MatchingEvent

}