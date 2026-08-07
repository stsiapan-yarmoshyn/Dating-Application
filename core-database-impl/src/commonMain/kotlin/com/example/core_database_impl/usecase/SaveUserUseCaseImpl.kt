package com.example.core_database_impl.usecase

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.core_database_api.data.repository.LocalUserRepository
import com.example.core_database_api.data.usecase.user.SaveUserUseCase

internal class SaveUserUseCaseImpl(
    private val repository: LocalUserRepository
): SaveUserUseCase {

    override suspend operator fun invoke(user: LocalUserProfileModel) {
        repository.saveUser(user)
    }

}