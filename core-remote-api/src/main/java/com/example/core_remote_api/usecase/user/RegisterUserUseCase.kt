package com.example.core_remote_api.usecase.user

import com.example.core_remote_api.model.RegistrationResponseModel
import com.example.core_remote_api.model.RemoteUserProfileModel

interface RegisterUserUseCase {

    suspend operator fun invoke(user: RemoteUserProfileModel): Result<RegistrationResponseModel>

}