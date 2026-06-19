package com.example.core_database_api.data.model

data class UserProfileModel(
    val userId: Int,
    val name: String,
    val gender: String,
    val email: String,
    val bio: String,
    val birthDate: String,
    val photos: List<String>,
    val searchGender: String,
)
