package com.example.feature_login_impl.data.usecase

import com.example.feature_login_api.model.UserProfileModel
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val authUserUseCase: AuthenticateUserUseCase
) {

    suspend operator fun invoke(email: String, password: String): Result<UserProfileModel> {
        return authUserUseCase(email, password).toFeatureModel()
    }

}