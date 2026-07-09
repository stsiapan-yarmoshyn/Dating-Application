package com.example.core_database_api.data.usecase

import com.example.core_database_api.data.model.UserProfileModel

interface GetUserByIdUseCase {

    suspend operator fun invoke(id: Int): UserProfileModel

}