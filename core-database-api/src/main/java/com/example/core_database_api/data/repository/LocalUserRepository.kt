package com.example.core_database_api.data.repository

import com.example.core_database_api.data.model.LocalUserProfileModel

interface LocalUserRepository {

    suspend fun getUserById(id: Int): LocalUserProfileModel

    suspend fun getUserByEmail(email: String): LocalUserProfileModel

    suspend fun saveUser(user: LocalUserProfileModel)

}