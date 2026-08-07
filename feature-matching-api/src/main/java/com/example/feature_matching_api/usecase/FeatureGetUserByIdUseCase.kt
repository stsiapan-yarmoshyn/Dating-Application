package com.example.feature_matching_api.usecase

import com.example.feature_matching_api.model.UserProfileModel

interface FeatureGetUserByIdUseCase {

    suspend operator fun invoke(userId: String): Result<UserProfileModel>

}