package com.example.core_database_impl.usecase

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.core_database_api.data.repository.LocalUserRepository
import com.example.core_database_api.data.usecase.user.GetUserByEmailUseCase

internal class GetUserByEmailUseCaseImpl(
    private val repository: LocalUserRepository
): GetUserByEmailUseCase {

    override suspend operator fun invoke(email: String): LocalUserProfileModel {
        return repository.getUserByEmail(email)
    }

}