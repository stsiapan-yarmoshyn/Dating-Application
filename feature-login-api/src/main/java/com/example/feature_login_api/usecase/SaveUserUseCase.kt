package com.example.feature_login_api.usecase

import com.example.feature_login_api.model.UserProfileModel

interface SaveUserUseCase {
    suspend operator fun invoke(user: UserProfileModel): Result<Unit>
}