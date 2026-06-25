package com.example.core_backendless_api.usecase.user

import com.example.core_backendless_api.model.UserProfileModel

interface RegisterUserUseCase {

    suspend operator fun invoke(user: UserProfileModel): Result<UserProfileModel>

}