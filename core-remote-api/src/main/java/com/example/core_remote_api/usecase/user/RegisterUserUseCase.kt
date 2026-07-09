package com.example.core_remote_api.usecase.user

import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.core_remote_api.model.RegistrationResponseModel

interface RegisterUserUseCase {

    suspend operator fun invoke(user: RemoteUserProfileModel): Result<RegistrationResponseModel>

}