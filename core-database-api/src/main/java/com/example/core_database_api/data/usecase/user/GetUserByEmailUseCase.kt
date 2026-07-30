package com.example.core_database_api.data.usecase.user

import com.example.core_database_api.data.model.LocalUserProfileModel

interface GetUserByEmailUseCase {

    suspend operator fun invoke(email: String): LocalUserProfileModel

}