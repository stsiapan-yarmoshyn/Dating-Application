package com.example.core_database_api.data.usecase

import com.example.core_database_api.data.model.UserProfileModel

interface GetUserByEmailUseCase {

    suspend operator fun invoke(email: String): UserProfileModel

}