package com.example.feature_login_impl.data.usecase

import com.example.core_remote_api.usecase.user.AuthenticateUserUseCase
import com.example.feature_login_api.model.UserProfileModel
import com.example.feature_login_api.usecase.LoginUserUseCase
import com.example.feature_login_impl.data.mapper.toFeatureModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginUserUseCaseImpl (
    private val authUserUseCase: AuthenticateUserUseCase
): LoginUserUseCase {

    override suspend operator fun invoke(email: String, password: String): Result<UserProfileModel> {
        return withContext(Dispatchers.IO) {
            authUserUseCase(email, password).map { it.toFeatureModel() }
        }
    }

}