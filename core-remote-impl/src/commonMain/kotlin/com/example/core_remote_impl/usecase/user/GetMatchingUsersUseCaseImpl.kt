package com.example.core_remote_impl.usecase.user

import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.core_remote_api.repository.RemoteUserRepository
import com.example.core_remote_api.usecase.user.GetMatchingUsersUseCase

internal class GetMatchingUsersUseCaseImpl(
    private val userRepository: RemoteUserRepository
): GetMatchingUsersUseCase {

    override suspend operator fun invoke(
        whereClause: String,
        pageSize: Int,
        offset: Int
    ): Result<List<RemoteUserProfileModel>> {
        return userRepository.getMatchingUsers(whereClause, pageSize, offset)
    }

}