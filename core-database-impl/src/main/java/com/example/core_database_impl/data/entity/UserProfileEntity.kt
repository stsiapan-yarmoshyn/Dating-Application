package com.example.core_database_impl.data.entity

import androidx.room.Entity
import java.time.LocalDate

const val USER_TABLE_NAME = "user_table"

@Entity(tableName = USER_TABLE_NAME)
data class UserProfileEntity(
    val userId: Int,
    val name: String,
    val gender: String,
    val age: Int,
    val email: String,
    val bio: String,
    val birthDate: String,
    val photos: List<String>,
    val searchGender: String,
)
