package com.example.feature_matching_impl.data.usecase

import com.example.feature_matching_api.model.UserProfileModel
import javax.inject.Inject

class GetMatchingUserUseCase @Inject constructor(
    private val getUserUseCase: GetUserUseCaseApi
) {

    suspend operator fun invoke(datingFilter: String): Result<UserProfileModel> {
        return getUserUseCase.getUser(userFilter.toDomain()).toResult()
    }

}