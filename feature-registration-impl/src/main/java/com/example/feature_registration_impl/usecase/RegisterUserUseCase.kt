package com.example.feature_registration_impl.usecase

import com.example.feature_registration_api.model.UserProfileModel
import com.example.feature_registration_impl.mapper.toDomain
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCaseApi
) {

    suspend operator fun invoke(userModel: UserProfileModel): Result<UserProfileModel> {
        return registerUserUseCase.registerUser(userModel.toDomain()).toFeature()
    }

}