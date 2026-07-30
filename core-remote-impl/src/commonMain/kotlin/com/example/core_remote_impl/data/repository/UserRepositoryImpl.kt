package com.example.core_remote_impl.data.repository

import com.example.core_remote_api.model.RegistrationResponseModel
import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.core_remote_api.repository.UserRepository
import com.example.core_remote_impl.data.mapper.user.toRegisterResponse
import com.example.core_remote_impl.data.mapper.user.toUserProfileList
import com.example.core_remote_impl.data.mapper.user.toUserProfileModel
import com.example.core_remote_impl.data.mapper.user.toUserRequestDto
import com.example.core_remote_impl.data.model.auth.LoginData
import com.example.core_remote_impl.data.network.UserServiceApi

internal class UserRepositoryImpl(
    private val userServiceApi: UserServiceApi
) : UserRepository {

    override suspend fun registerUser(user: RemoteUserProfileModel): Result<RegistrationResponseModel> {
        return runCatching {
            val result = userServiceApi.executeRegisterUserTransaction(user.toUserRequestDto())
            result.toRegisterResponse()
        }
    }

    override suspend fun loginUser(
        login: String,
        password: String
    ): Result<RemoteUserProfileModel> {
        return runCatching {
            val result = userServiceApi.loginUser(LoginData(login, password))
            result.toUserProfileModel()
        }
    }

    override suspend fun deleteUser(userId: String): Result<Unit> {
        return runCatching {
            userServiceApi.deleteUser(userId)
        }
    }

    override suspend fun getMatchingUsers(
        whereClause: String,
        pageSize: Int,
        offset: Int
    ): Result<List<RemoteUserProfileModel>> {
        return runCatching {
            //Offset should be calculated by page size. Like offset += page size
            userServiceApi.getMatchingUser(whereClause, pageSize, offset).toUserProfileList()
        }
    }
}