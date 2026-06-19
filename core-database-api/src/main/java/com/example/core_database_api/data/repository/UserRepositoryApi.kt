package com.example.core_database_api.data.repository

import com.example.core_database_api.data.model.UserProfileModel

interface UserRepositoryApi {

    suspend fun getUserById(id: Int): UserProfileModel

    suspend fun getUserByEmail(email: String): UserProfileModel

    suspend fun saveUser(user: UserProfileModel)


}