package com.example.core_database_api.data.usecase

import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_api.data.repository.UserRepository
import javax.inject.Inject

class GetUserByEmail @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(email: String): UserProfileModel {
        return repository.getUserByEmail(email)
    }

}