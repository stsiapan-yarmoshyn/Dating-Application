package com.example.core_database_api.data.usecase

import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_api.data.repository.UserRepositoryApi
import javax.inject.Inject

class GetUserByEmailUseCase @Inject constructor(private val repository: UserRepositoryApi) {

    suspend operator fun invoke(email: String): UserProfileModel {
        return repository.getUserByEmail(email)
    }

}