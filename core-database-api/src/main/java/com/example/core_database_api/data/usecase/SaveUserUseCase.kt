package com.example.core_database_api.data.usecase

import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_api.data.repository.UserRepository
import javax.inject.Inject

interface SaveUserUseCase {

    suspend operator fun invoke(user: UserProfileModel)

}