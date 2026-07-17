package com.example.datingapplication.navigation

import androidx.navigation.NavController
import com.example.core_navigation_api.FeatureDestination

interface FeatureNavAdapter {

    fun handleDestination(destination: FeatureDestination, navController: NavController): Boolean

}