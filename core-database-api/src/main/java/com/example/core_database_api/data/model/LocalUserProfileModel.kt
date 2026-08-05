package com.example.core_database_api.data.model

data class LocalUserProfileModel(
    val userId: String,
    val name: String,
    val gender: String,
    val email: String,
    val bio: String,
    val birthDate: Long,
    val photos: List<LocalPhotoModel>,
    val searchGender: String,
)
