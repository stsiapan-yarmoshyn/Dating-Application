package com.example.core_database_impl.data.repository

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.core_database_api.data.repository.LocalUserRepository
import com.example.core_database_impl.data.dao.UserDao
import com.example.core_database_impl.data.mapper.toDomain
import com.example.core_database_impl.data.mapper.toEntityWithPhotos

internal class UserRepositoryImpl(
    private val userDao: UserDao
): LocalUserRepository {

    override suspend fun getUserById(id: Int): LocalUserProfileModel {
        return userDao.getUserById(id).toDomain()
    }

    override suspend fun getUserByEmail(email: String): LocalUserProfileModel {
        return userDao.getUserByEmail(email).toDomain()
    }

    override suspend fun saveUser(user: LocalUserProfileModel) {
        userDao.insertUserWithPhotos(user.toEntityWithPhotos(isCurrentUser = true))
    }
}