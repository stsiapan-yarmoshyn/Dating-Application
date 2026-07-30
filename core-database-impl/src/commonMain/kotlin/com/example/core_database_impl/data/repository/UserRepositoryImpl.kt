package com.example.core_database_impl.data.repository

import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_api.data.repository.UserRepository
import com.example.core_database_impl.data.dao.UserDao
import com.example.core_database_impl.data.mapper.toDomain
import com.example.core_database_impl.data.mapper.toEntity

internal class UserRepositoryImpl(
    private val userDao: UserDao
): UserRepository {

    override suspend fun getUserById(id: Int): UserProfileModel {
        return userDao.getUserById(id).toDomain()
    }

    override suspend fun getUserByEmail(email: String): UserProfileModel {
        return userDao.getUserByEmail(email).toDomain()
    }

    override suspend fun saveUser(user: LocalUserProfileModel) {
        userDao.insertUserWithPhotos(user.toEntityWithPhotos(isCurrentUser = true))
    }
}