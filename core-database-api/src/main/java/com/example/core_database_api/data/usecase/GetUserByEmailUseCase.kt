package com.example.core_database_api.data.usecase

import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_api.data.repository.UserRepository
import javax.inject.Inject

interface GetUserByEmailUseCase {

    suspend operator fun invoke(email: String): UserProfileModel

}