package com.example.core_database_impl.data.dao

import com.example.core_database_api.data.dao.UserDaoApi
import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_impl.data.entity.UserProfileEntity

interface UserDao: UserDaoApi {

    fun getRoomUserByEmail(email: String): UserProfileEntity?

    fun getRoomUserById(email: String): UserProfileEntity?

    override suspend fun getUserByEmail(email: String): UserProfileModel? {
        return getRoomUserByEmail(email).toDomain()
    }

    override suspend fun getUserById(id: Int): UserProfileModel? {
        return getRoomUserById(email).toDomain()
    }
}