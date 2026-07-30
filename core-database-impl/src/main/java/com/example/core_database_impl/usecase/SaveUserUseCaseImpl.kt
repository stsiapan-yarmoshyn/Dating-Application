package com.example.core_database_impl.usecase

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.core_database_api.data.repository.LocalUserRepository
import com.example.core_database_api.data.usecase.user.SaveUserUseCase
import javax.inject.Inject

internal class SaveUserUseCaseImpl @Inject constructor(
    private val repository: LocalUserRepository
): SaveUserUseCase {

    override suspend operator fun invoke(user: LocalUserProfileModel) {
        repository.saveUser(user)
    }

}