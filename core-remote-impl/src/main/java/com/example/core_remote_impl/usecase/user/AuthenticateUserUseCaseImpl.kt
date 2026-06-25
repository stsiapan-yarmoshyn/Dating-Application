package com.example.core_remote_impl.usecase.user

import com.example.core_backendless_api.repository.UserRepository
import com.example.core_backendless_api.usecase.user.AuthenticateUserUseCase
import javax.inject.Inject

internal class AuthenticateUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : AuthenticateUserUseCase {

    override suspend fun invoke(email: String, password: String) {
        userRepository.loginUser(email, password)
    }

}