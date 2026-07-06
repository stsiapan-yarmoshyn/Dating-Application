package com.example.feature_matching_impl.screen

sealed interface MatchingEvent {

    object LoadNextPage: MatchingEvent
    class OnCardSwiped(val isLiked: Boolean): MatchingEvent

}