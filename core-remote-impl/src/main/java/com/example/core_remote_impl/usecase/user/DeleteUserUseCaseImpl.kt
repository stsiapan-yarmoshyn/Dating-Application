package com.example.core_remote_impl.usecase.user

import com.example.core_backendless_api.model.UserProfileModel
import com.example.core_backendless_api.repository.UserRepository
import com.example.core_backendless_api.usecase.user.DeleteUserUseCase
import javax.inject.Inject

internal class DeleteUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
): DeleteUserUseCase {

    override suspend fun invoke(userId: String) {
        userRepository.deleteUser(userId)
    }

}