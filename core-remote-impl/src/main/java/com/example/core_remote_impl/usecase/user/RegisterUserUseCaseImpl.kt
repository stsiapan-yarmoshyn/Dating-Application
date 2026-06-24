package com.example.core_remote_impl.usecase.user

import com.example.core_backendless_api.model.UserProfileModel
import com.example.core_backendless_api.repository.UserRepository
import com.example.core_backendless_api.usecase.user.RegisterUserUseCase
import javax.inject.Inject

internal class RegisterUserUseCaseImpl @Inject constructor(
   private val userRepository: UserRepository
): RegisterUserUseCase {

    override suspend fun invoke(user: UserProfileModel) {
        userRepository.registerUser(user)
    }

}