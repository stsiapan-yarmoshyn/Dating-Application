package com.example.core_remote_impl.usecase.user

import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.core_remote_api.repository.RemoteUserRepository
import com.example.core_remote_api.usecase.user.GetMatchingUsersUseCase
import javax.inject.Inject

internal class GetMatchingUsersUseCaseImpl @Inject constructor(
    private val remoteUserRepository: RemoteUserRepository
): GetMatchingUsersUseCase {

    override suspend operator fun invoke(
        whereClause: String,
        pageSize: Int,
        offset: Int
    ): Result<List<RemoteUserProfileModel>> {
        return remoteUserRepository.getMatchingUsers(whereClause, pageSize, offset)
    }

}