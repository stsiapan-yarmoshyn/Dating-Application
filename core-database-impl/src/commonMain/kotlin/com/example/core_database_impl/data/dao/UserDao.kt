package com.example.core_database_impl.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.example.core_database_impl.data.entity.PhotoEntity
import com.example.core_database_impl.data.entity.UserProfileEntity
import com.example.core_database_impl.data.entity.relation.UserWithPhotos

@Dao
internal interface UserDao {

    @Transaction
    @Query("SELECT * FROM user_table WHERE email = :email")
    suspend fun getUserByEmail(email: String): UserWithPhotos

    @Transaction
    @Query("SELECT * FROM user_table WHERE userId = :id")
    suspend fun getUserById(id: Int): UserWithPhotos

    @Insert(onConflict = REPLACE)
    suspend fun saveUser(userEntity: UserProfileEntity)

    @Insert(onConflict = REPLACE)
    suspend fun savePhotosForUser(photos: List<PhotoEntity>)

    @Transaction
    suspend fun insertUserWithPhotos(userWithPhotos: UserWithPhotos) {
        saveUser(userWithPhotos.user)
        savePhotosForUser(userWithPhotos.photos)
    }

}