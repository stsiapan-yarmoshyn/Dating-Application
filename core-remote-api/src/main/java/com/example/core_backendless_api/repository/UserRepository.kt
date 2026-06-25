package com.example.core_backendless_api.repository

import com.example.core_backendless_api.model.UserProfileModel

interface UserRepository {

    suspend fun registerUser(user: UserProfileModel)

    suspend fun loginUser(login: String, password: String)

    suspend fun deleteUser(userId: String)

}