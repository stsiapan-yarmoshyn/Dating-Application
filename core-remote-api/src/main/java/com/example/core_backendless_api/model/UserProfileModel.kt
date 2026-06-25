package com.example.core_backendless_api.model

data class UserProfileModel(
    val name: String,
    val gender: String,
    val email: String,
    val password: String,
    val bio: String,
    val birthDate: Long,
    val photos: List<PhotoModel>,
    val searchGender: String,
    val lastLogin: Long? = null,
    val created: Long? = null,
)
