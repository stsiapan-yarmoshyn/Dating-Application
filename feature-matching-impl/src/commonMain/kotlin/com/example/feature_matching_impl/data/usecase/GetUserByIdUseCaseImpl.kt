package com.example.feature_matching_impl.data.usecase

import com.example.core_database_api.data.usecase.user.GetUserByIdUseCase
import com.example.feature_matching_api.model.UserProfileModel
import com.example.feature_matching_api.usecase.FeatureGetUserByIdUseCase
import com.example.feature_matching_impl.data.mapper.toFeatureProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FeatureGetUserByIdUseCaseImpl(
    private val getUserByIdUseCase: GetUserByIdUseCase
) : FeatureGetUserByIdUseCase {

    override suspend operator fun invoke(userId: String): Result<UserProfileModel> {
        return withContext(Dispatchers.IO) {
             getUserByIdUseCase(userId).map { it.toFeatureProfile() }
        }
    }

}