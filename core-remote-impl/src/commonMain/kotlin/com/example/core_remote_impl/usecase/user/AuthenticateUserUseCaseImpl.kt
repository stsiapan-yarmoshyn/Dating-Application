package com.example.core_remote_impl.usecase.user

import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.core_remote_api.repository.UserRepository
import com.example.core_remote_api.usecase.user.AuthenticateUserUseCase

internal class AuthenticateUserUseCaseImpl(
    private val userRepository: UserRepository
) : AuthenticateUserUseCase {

    override suspend operator fun invoke(email: String, password: String): Result<RemoteUserProfileModel> {
        return userRepository.loginUser(email, password)
    }

}