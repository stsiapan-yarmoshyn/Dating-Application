package com.example.core_backendless_api.usecase.user

import com.example.core_backendless_api.model.UserProfileModel

interface DeleteUserUseCase {

    suspend operator fun invoke(userId: String)

}