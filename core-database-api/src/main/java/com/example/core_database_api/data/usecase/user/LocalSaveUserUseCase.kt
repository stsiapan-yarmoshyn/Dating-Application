package com.example.core_database_api.data.usecase.user

import com.example.core_database_api.data.model.LocalUserProfileModel
interface LocalSaveUserUseCase {

    suspend operator fun invoke(user: LocalUserProfileModel): Result<Unit>

}