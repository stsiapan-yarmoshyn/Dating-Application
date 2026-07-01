package com.example.core_backendless_api.usecase.user

import com.example.core_backendless_api.model.RemoteUserProfileModel
import com.example.core_backendless_api.model.RegistrationResponseModel

interface RegisterUserUseCase {

    suspend operator fun invoke(user: RemoteUserProfileModel): Result<RegistrationResponseModel>

}