package com.example.core_database_impl.usecase

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.core_database_api.data.repository.LocalUserRepository
import com.example.core_database_api.data.usecase.user.GetUserByIdUseCase

internal class GetUserByIdUseCaseImpl(
    private val repository: LocalUserRepository
): GetUserByIdUseCase {

    override suspend operator fun invoke(id: Int): LocalUserProfileModel {
        return repository.getUserById(id)
    }

}