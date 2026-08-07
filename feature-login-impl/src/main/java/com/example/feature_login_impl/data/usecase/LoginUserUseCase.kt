package com.example.feature_login_impl.data.usecase

import com.example.feature_login_api.model.UserProfileModel
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val authUserUseCase: AuthenticateUserUseCase
) {

    suspend operator fun invoke(email: String, password: String): Result<UserProfileModel> {
        withContext(Dispatchers.IO) {
            return authUserUseCase(email, password).toFeatureModel()
        }
    }

}