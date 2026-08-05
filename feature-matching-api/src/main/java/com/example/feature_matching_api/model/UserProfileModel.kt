package com.example.feature_matching_api.model

data class UserProfileModel (
    val userId: String,
    val name: String,
    val gender: String,
    val email: String,
    val bio: String,
    val birthDate: Long,
    val photos: List<PhotoModel>,
    val searchGender: String,
)
