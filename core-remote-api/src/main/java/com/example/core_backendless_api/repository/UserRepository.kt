package com.example.core_backendless_api.repository

import com.example.core_backendless_api.model.UserProfileModel

interface UserRepository {

    suspend fun registerUser(user: UserProfileModel): Result<UserProfileModel>

    suspend fun loginUser(login: String, password: String): Result<UserProfileModel>

    suspend fun deleteUser(userId: String)

}