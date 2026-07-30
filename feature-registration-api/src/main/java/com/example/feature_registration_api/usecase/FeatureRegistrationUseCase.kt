package com.example.feature_registration_api.usecase

import com.example.feature_registration_api.model.RegistrationData
import com.example.feature_registration_api.model.UserProfileModel

interface FeatureRegistrationUseCase {

    suspend operator fun invoke(userModel: UserProfileModel): Result<RegistrationData>
}