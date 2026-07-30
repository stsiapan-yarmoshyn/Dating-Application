package com.example.core_remote_impl.usecase.user

import com.example.core_remote_api.repository.RemoteUserRepository
import com.example.core_remote_api.usecase.user.DeleteUserUseCase
import javax.inject.Inject

internal class DeleteUserUseCaseImpl @Inject constructor(
    private val remoteUserRepository: RemoteUserRepository
): DeleteUserUseCase {

    override suspend operator fun invoke(userId: String) {
        remoteUserRepository.deleteUser(userId)
    }

}