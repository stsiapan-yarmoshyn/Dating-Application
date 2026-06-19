package com.example.core_database_impl.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.core_database_impl.data.entity.UserProfileEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table WHERE email = :email")
    suspend fun getUserByEmail(email: String): UserProfileEntity

    @Query("SELECT * FROM user_table WHERE userId = :id")
    suspend fun getUserById(id: Int): UserProfileEntity

    @Insert(onConflict = REPLACE)
    suspend fun saveUser(userEntity: UserProfileEntity)
}