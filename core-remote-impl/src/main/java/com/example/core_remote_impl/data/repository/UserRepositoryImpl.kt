package com.example.core_remote_impl.data.repository

import com.example.core_backendless_api.model.UserProfileModel
import com.example.core_backendless_api.repository.UserRepository
import com.example.core_remote_impl.data.mapper.auth.toUserProfileDto
import com.example.core_remote_impl.data.network.auth.BackendlessAuthApi
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val backendlessAuthApi: BackendlessAuthApi
): UserRepository {

    override suspend fun registerUser(user: UserProfileModel) {
        backendlessAuthApi.executeTransaction(user.toUserProfileDto())
    }

    override suspend fun authenticateUser(user: UserProfileModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(user: UserProfileModel) {
        TODO("Not yet implemented")
    }
}