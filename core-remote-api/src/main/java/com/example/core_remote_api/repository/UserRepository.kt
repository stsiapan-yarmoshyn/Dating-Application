package com.example.core_remote_api.repository

import com.example.core_remote_api.model.RegistrationResponseModel
import com.example.core_remote_api.model.RemoteUserProfileModel

interface UserRepository {

    suspend fun registerUser(user: RemoteUserProfileModel): Result<RegistrationResponseModel>

    suspend fun loginUser(login: String, password: String): Result<RemoteUserProfileModel>

    suspend fun deleteUser(userId: String): Result<Unit>

    suspend fun getMatchingUsers(whereClause: String, pageSize: Int, offset: Int): Result<List<RemoteUserProfileModel>>

}