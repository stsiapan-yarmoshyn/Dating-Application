package com.example.core_database_api.data.usecase.session

import com.example.core_database_api.data.model.LocalUserProfileModel

interface ClearSessionUseCase {
    suspend operator fun invoke()
}
