package com.example.core_database_impl.usecase.session

import com.example.core_database_api.data.repository.SessionManager
import com.example.core_database_api.data.usecase.session.ClearSessionUseCase

internal class ClearSessionUseCaseImpl(
    private val manager: SessionManager
): ClearSessionUseCase {
    override suspend fun invoke() {
        manager.clearSession()
    }
}
