package com.example.core_database_impl.usecase.session

import com.example.core_database_api.data.repository.SessionManager
import com.example.core_database_api.data.usecase.session.GetUserTokenUseCase

internal class GetUserTokenUseCaseImpl(
    private val manager: SessionManager
): GetUserTokenUseCase {
    override suspend fun invoke(): String? {
        return manager.getUserToken()
    }
}