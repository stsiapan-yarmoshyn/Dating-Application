package com.example.core_remote_impl.usecase.user

import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.core_remote_api.repository.RemoteUserRepository
import com.example.core_remote_api.usecase.user.AuthenticateUserUseCase
import javax.inject.Inject

internal class AuthenticateUserUseCaseImpl @Inject constructor(
    private val remoteUserRepository: RemoteUserRepository
) : AuthenticateUserUseCase {

    override suspend operator fun invoke(email: String, password: String): Result<RemoteUserProfileModel> {
        return remoteUserRepository.loginUser(email, password)
    }

}