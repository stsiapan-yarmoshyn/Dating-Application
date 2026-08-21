package com.example.core_remote_impl.usecase.user

import com.example.core_remote_api.repository.RemoteUserRepository
import com.example.core_remote_api.usecase.user.CheckTokenValidationUseCase
import com.example.core_remote_api.usecase.user.DeleteUserUseCase

class CheckTokenValidationUseCaseImpl(
    private val userRepository: RemoteUserRepository
): CheckTokenValidationUseCase {

    override suspend operator fun invoke(): Result<Boolean> {
        return userRepository.checkTokenValidation()
    }

}