package com.example.core_database_impl.usecase

import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_api.data.repository.UserRepository
import com.example.core_database_api.data.usecase.GetUserByEmailUseCase

internal class GetUserByEmailUseCaseImpl(
    private val repository: UserRepository
): GetUserByEmailUseCase {

    override suspend operator fun invoke(email: String): UserProfileModel {
        return repository.getUserByEmail(email)
    }

}