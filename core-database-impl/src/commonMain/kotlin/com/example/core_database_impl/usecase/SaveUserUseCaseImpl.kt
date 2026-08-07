package com.example.core_database_impl.usecase

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.core_database_api.data.repository.LocalUserRepository
import com.example.core_database_api.data.usecase.user.LocalSaveUserUseCase

internal class SaveUserUseCaseImpl(
    private val repository: LocalUserRepository
): LocalSaveUserUseCase {

    override suspend operator fun invoke(user: LocalUserProfileModel): Result<Unit> {
        return repository.saveUser(user)
    }

}