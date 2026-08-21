package com.example.core_database_impl.usecase.session

import com.example.core_database_api.data.repository.SessionManager
import com.example.core_database_api.data.usecase.session.SaveUserTokenUseCase

class SaveUserTokenUseCaseImpl(
    private val manager: SessionManager
): SaveUserTokenUseCase {
    override suspend fun invoke(token: String) {
        manager.saveUserToken(token)
    }
}