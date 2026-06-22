package com.example.core_database_api.data.usecase

import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_api.data.repository.UserRepository
import javax.inject.Inject

internal class GetUserByIdUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(id: Int): UserProfileModel {
        return repository.getUserById(id)
    }

}