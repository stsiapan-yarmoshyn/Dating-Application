package com.example.feature_login_impl.data.usecase

import com.example.core_database_api.data.usecase.user.LocalSaveUserUseCase
import com.example.feature_login_api.model.UserProfileModel
import com.example.feature_login_api.usecase.SaveUserUseCase
import com.example.feature_login_impl.data.mapper.toLocalModel

class SaveUserUseCaseImpl (
    private val saveUserUseCaseLocal: LocalSaveUserUseCase
): SaveUserUseCase {

    override suspend operator fun invoke(user: UserProfileModel): Result<Unit> {
        return saveUserUseCaseLocal(user.toLocalModel())
    }
}