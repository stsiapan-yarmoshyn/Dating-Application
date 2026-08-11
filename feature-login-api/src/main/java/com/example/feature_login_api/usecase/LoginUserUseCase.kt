package com.example.feature_login_api.usecase

import com.example.feature_login_api.model.UserProfileModel

interface LoginUserUseCase {
    suspend operator fun invoke(email: String, password: String): Result<UserProfileModel>
}