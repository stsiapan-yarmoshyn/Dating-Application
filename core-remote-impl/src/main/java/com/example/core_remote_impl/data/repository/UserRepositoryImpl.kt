package com.example.core_remote_impl.data.repository

import com.example.core_backendless_api.model.UserProfileModel
import com.example.core_backendless_api.repository.UserRepository
import com.example.core_remote_impl.data.mapper.register.toUserProfileDto
import com.example.core_remote_impl.data.model.auth.LoginData
import com.example.core_remote_impl.data.network.UserServiceApi
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val backendlessAuthApi: UserServiceApi
): UserRepository {

    override suspend fun registerUser(user: UserProfileModel) {
        backendlessAuthApi.executeRegisterUserTransaction(user.toUserProfileDto())
    }

    override suspend fun authenticateUser(login: String, password: String) {
        backendlessAuthApi.loginUser(LoginData(login, password))
    }

    override suspend fun deleteUser(userId: String) {
        backendlessAuthApi.deleteUser(userId)
    }
}