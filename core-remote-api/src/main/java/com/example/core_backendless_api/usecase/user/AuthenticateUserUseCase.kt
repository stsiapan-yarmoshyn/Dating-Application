package com.example.core_backendless_api.usecase.user

import com.example.core_backendless_api.model.UserProfileModel

interface AuthenticateUserUseCase {

    suspend operator fun invoke(email: String, password: String)

}