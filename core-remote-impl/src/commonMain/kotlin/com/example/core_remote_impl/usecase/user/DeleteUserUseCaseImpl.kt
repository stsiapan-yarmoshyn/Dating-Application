package com.example.core_remote_impl.usecase.user

import com.example.core_remote_api.repository.RemoteUserRepository
import com.example.core_remote_api.usecase.user.DeleteUserUseCase

internal class DeleteUserUseCaseImpl(
    private val userRepository: RemoteUserRepository
): DeleteUserUseCase {

    override suspend operator fun invoke(userId: String) {
        userRepository.deleteUser(userId)
    }

}