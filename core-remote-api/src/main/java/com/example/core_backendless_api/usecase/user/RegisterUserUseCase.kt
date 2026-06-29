package com.example.core_backendless_api.usecase.user

import com.example.core_backendless_api.model.DomainUserProfileModel
import com.example.core_backendless_api.model.RegistrationResponseModel

interface RegisterUserUseCase {

    suspend operator fun invoke(user: DomainUserProfileModel): Result<RegistrationResponseModel>

}