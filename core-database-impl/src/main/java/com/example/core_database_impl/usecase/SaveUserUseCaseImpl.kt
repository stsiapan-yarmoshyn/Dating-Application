package com.example.core_database_impl.usecase

import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_api.data.repository.UserRepository
import com.example.core_database_api.data.usecase.SaveUserUseCase
import javax.inject.Inject

internal class SaveUserUseCaseImpl @Inject constructor(
    private val repository: UserRepository
): SaveUserUseCase {

    override suspend operator fun invoke(user: UserProfileModel) {
        repository.saveUser(user)
    }

}