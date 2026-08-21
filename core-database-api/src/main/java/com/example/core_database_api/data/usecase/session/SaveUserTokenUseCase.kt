package com.example.core_database_api.data.usecase.session

interface SaveUserTokenUseCase {
    suspend operator fun invoke(token: String)
}
