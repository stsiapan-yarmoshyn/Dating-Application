package com.example.core_database_impl.usecase

import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_api.data.repository.UserRepository
import com.example.core_database_api.data.usecase.GetUserByIdUseCase

internal class GetUserByIdUseCaseImpl(
    private val repository: UserRepository
): GetUserByIdUseCase {

    override suspend operator fun invoke(id: Int): UserProfileModel {
        return repository.getUserById(id)
    }

}