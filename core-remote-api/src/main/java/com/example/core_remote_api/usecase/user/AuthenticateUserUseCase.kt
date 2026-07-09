package com.example.core_remote_api.usecase.user

import com.example.core_remote_api.model.RemoteUserProfileModel

interface AuthenticateUserUseCase {

    suspend operator fun invoke(email: String, password: String): Result<RemoteUserProfileModel>

}