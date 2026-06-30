package com.example.feature_login_impl.data.usecase

import com.example.feature_login_api.model.UserProfileModel
import com.example.feature_login_impl.data.mapper.toLocalModel
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val saveUserUseCaseDb: SaveUserUseCaseLocal
) {

    suspend operator fun invoke(user: UserProfileModel): Result<Boolean> {
        return saveUserUseCaseLocal(user.toLocalModel())
    }

}