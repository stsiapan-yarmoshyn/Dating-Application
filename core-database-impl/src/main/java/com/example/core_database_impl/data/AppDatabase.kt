package com.example.core_database_impl.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_database_impl.data.dao.UserDao
import com.example.core_database_impl.data.entity.UserProfileEntity

@Database(
    entities = [
        UserProfileEntity::class,
    ],
    version = 1
)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}