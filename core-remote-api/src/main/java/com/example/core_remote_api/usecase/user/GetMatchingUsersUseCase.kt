package com.example.core_remote_api.usecase.user

import com.example.core_remote_api.model.RemoteUserProfileModel

interface GetMatchingUsersUseCase {

    suspend operator fun invoke(whereClause: String, pageSize: Int, offset: Int): Result<List<RemoteUserProfileModel>>

}