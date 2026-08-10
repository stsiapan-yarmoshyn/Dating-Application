package com.example.feature_matching_api.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface MatchingRoute: NavKey {
    @Serializable
    @SerialName("MatchingMain")
    data object MatchingMain: MatchingRoute

    @Serializable
    @SerialName("MatchingDetails")
    data class MatchingDetails(val id: String): MatchingRoute
}