package com.example.core_database_impl.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserProfileEntity.USER_TABLE_NAME)
internal data class UserProfileEntity(
    @PrimaryKey val userId: String,
    val name: String,
    val gender: String,
    val email: String,
    val bio: String,
    val birthDate: String,
    val searchGender: String,
) {
    companion object {
        const val USER_TABLE_NAME = "user_table"
    }
}
