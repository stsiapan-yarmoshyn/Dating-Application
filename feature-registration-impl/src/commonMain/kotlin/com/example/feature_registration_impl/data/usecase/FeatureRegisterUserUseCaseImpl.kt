package com.example.feature_registration_impl.data.usecase

import com.example.core_remote_api.usecase.user.RegisterUserUseCase
import com.example.feature_registration_api.model.RegistrationData
import com.example.feature_registration_api.model.UserProfileModel
import com.example.feature_registration_api.usecase.FeatureRegistrationUseCase
import com.example.feature_registration_impl.data.mapper.toDomain
import com.example.feature_registration_impl.data.mapper.toFeatureData

class FeatureRegisterUserUseCaseImpl (
    private val registerUserUseCase: RegisterUserUseCase
) : FeatureRegistrationUseCase {
    override suspend operator fun invoke(userModel: UserProfileModel): Result<RegistrationData> {
       return registerUserUseCase(userModel.toDomain()).map { it.toFeatureData() }
    }
}