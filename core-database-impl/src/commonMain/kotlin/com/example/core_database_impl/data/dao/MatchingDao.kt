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
internal interface MatchingDao {

    @Insert(onConflict = REPLACE)
    suspend fun cacheMatchingUsers(users: List<UserProfileEntity>)

    @Insert(onConflict = REPLACE)
    suspend fun savePhotosForUser(photos: List<PhotoEntity>)

    @Transaction
    suspend fun cacheUsersWithPhotos(usersList: List<UserWithPhotos>) {
        val allUsers = usersList.map { it.user }
        val allPhotos = usersList.flatMap { it.photos }

        cacheMatchingUsers(allUsers)
        savePhotosForUser(allPhotos)
    }

    @Transaction
    @Query("SELECT * FROM user_table WHERE isCachedUser = 1")
    suspend fun getCachedMatchingUsers(): List<UserWithPhotos>

    @Query("DELETE FROM user_table WHERE userId = :userId AND isCachedUser = true")
    suspend fun deleteCachedUser(userId: String)

    @Query("DELETE FROM user_table WHERE isCachedUser = 1")
    suspend fun clearAllCachedUsers()
}