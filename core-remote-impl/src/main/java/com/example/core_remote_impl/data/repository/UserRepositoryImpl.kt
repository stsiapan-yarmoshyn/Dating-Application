package com.example.core_remote_impl.data.repository

import com.example.core_backendless_api.model.DomainUserProfileModel
import com.example.core_backendless_api.model.RegistrationResponseModel
import com.example.core_backendless_api.repository.UserRepository
import com.example.core_remote_impl.data.mapper.user.toRegisterResponse
import com.example.core_remote_impl.data.mapper.user.toUserProfileDtoForRegistration
import com.example.core_remote_impl.data.mapper.user.toUserProfileModel
import com.example.core_remote_impl.data.model.auth.LoginData
import com.example.core_remote_impl.data.network.UserServiceApi
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userServiceApi: UserServiceApi
): UserRepository {

    override suspend fun registerUser(user: DomainUserProfileModel): Result<RegistrationResponseModel> {
        return runCatching {
            val result = userServiceApi.executeRegisterUserTransaction(user.toUserProfileDtoForRegistration())
            result.toRegisterResponse()
        }
    }

    override suspend fun loginUser(login: String, password: String): Result<DomainUserProfileModel> {
        return runCatching {
            val result = userServiceApi.loginUser(LoginData(login, password))
            result.toUserProfileModel()
        }
    }

    override suspend fun deleteUser(userId: String) {
        userServiceApi.deleteUser(userId)
    }
}