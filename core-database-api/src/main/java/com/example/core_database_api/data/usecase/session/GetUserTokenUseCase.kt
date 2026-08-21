package com.example.core_database_api.data.usecase.session

interface GetUserTokenUseCase {
    suspend operator fun invoke(): String?
}
