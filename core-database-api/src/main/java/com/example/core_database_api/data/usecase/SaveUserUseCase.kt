package com.example.core_database_api.data.usecase

import com.example.core_database_api.data.model.UserProfileModel
interface SaveUserUseCase {

    suspend operator fun invoke(user: UserProfileModel)

}