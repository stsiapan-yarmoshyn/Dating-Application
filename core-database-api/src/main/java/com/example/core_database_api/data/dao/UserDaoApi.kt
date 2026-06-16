package com.example.core_database_api.data.dao

import com.example.core_database_api.data.model.UserProfileModel

interface UserDaoApi {

    suspend fun getUserById(id: Int): UserProfileModel?

    suspend fun getUserByEmail(email: String): UserProfileModel?

}