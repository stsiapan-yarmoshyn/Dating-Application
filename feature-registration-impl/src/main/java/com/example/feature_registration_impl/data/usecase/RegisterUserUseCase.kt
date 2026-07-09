package com.example.feature_registration_impl.data.usecase

import com.example.feature_registration_api.model.RegistrationResultModel
import com.example.feature_registration_api.model.UserProfileModel
import com.example.feature_registration_impl.data.mapper.toDomain
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCaseApi
) {

    suspend operator fun invoke(userModel: UserProfileModel): Result<RegistrationResultModel> {
        return registerUserUseCase.registerUser(userModel.toDomain()).toResult()
    }

}