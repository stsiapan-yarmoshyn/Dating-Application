package com.example.core_database_impl.data.repository

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.core_database_api.data.repository.LocalMatchingRepository
import com.example.core_database_impl.data.dao.MatchingDao
import com.example.core_database_impl.data.mapper.toDomainList
import com.example.core_database_impl.data.mapper.toEntityListWithPhotos

internal class MatchingRepositoryImpl(
    private val matchingDao: MatchingDao,
): LocalMatchingRepository {

    override suspend fun cacheMatchingUsers(users: List<LocalUserProfileModel>) {
        matchingDao.cacheUsersWithPhotos(users.toEntityListWithPhotos(isCachedUser = true))
    }

    override suspend fun getCachedMatchingUsers(): List<LocalUserProfileModel> {
        return matchingDao.getCachedMatchingUsers().toDomainList()
    }

    override suspend fun deleteCachedMatchingUser(userId: String) {
        matchingDao.deleteCachedUser(userId)
    }

    override suspend fun clearAllCachedUsers() {
        matchingDao.clearAllCachedUsers()
    }

}