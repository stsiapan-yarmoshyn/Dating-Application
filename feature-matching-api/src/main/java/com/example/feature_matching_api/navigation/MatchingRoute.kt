package com.example.feature_matching_api.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
interface MatchingRoute: NavKey {
    @Serializable
    data object Main: MatchingRoute

    @Serializable
    data class Details(val id: String): MatchingRoute
}