package com.example.core_remote_impl.usecase.user

import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.core_remote_api.model.RegistrationResponseModel
import com.example.core_remote_api.repository.UserRepository
import com.example.core_remote_api.usecase.user.RegisterUserUseCase
import javax.inject.Inject

internal class RegisterUserUseCaseImpl @Inject constructor(
   private val userRepository: UserRepository
): RegisterUserUseCase {

    override suspend operator fun invoke(user: RemoteUserProfileModel): Result<RegistrationResponseModel> {
        return userRepository.registerUser(user)
    }

}