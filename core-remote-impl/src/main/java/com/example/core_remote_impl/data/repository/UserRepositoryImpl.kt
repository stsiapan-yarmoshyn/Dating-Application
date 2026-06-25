package com.example.core_remote_impl.data.repository

import com.example.core_backendless_api.model.UserProfileModel
import com.example.core_backendless_api.repository.UserRepository
import com.example.core_remote_impl.data.mapper.user.toUserProfileDtoForRegistration
import com.example.core_remote_impl.data.model.auth.LoginData
import com.example.core_remote_impl.data.network.UserServiceApi
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userServiceApi: UserServiceApi
): UserRepository {

    override suspend fun registerUser(user: UserProfileModel) {
        userServiceApi.executeRegisterUserTransaction(user.toUserProfileDtoForRegistration())
    }

    override suspend fun loginUser(login: String, password: String) {
        userServiceApi.loginUser(LoginData(login, password))
    }

    override suspend fun deleteUser(userId: String) {
        userServiceApi.deleteUser(userId)
    }
}