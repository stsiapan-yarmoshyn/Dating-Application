package com.example.core_database_api.data.repository

import com.example.core_database_api.data.model.LocalUserProfileModel

interface LocalMatchingRepository {

    suspend fun cacheMatchingUsers(users: List<LocalUserProfileModel>)

    suspend fun getCachedMatchingUsers(): List<LocalUserProfileModel>

    suspend fun deleteCachedMatchingUser(userId: String)

    suspend fun clearAllCachedUsers()

}