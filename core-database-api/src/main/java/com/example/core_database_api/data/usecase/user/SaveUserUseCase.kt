package com.example.core_database_api.data.usecase.user

import com.example.core_database_api.data.model.LocalUserProfileModel
interface SaveUserUseCase {

    suspend operator fun invoke(user: LocalUserProfileModel)

}