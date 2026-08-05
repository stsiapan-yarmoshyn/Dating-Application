package com.example.core_database_api.data.usecase.user

import com.example.core_database_api.data.model.LocalUserProfileModel

interface GetUserByIdUseCase {

    suspend operator fun invoke(id: String): Result<LocalUserProfileModel>

}