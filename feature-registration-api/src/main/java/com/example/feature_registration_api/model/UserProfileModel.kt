package com.example.feature_registration_api.model

data class UserProfileModel (
    val name: String,
    val gender: String,
    val email: String,
    val password: String,
    val bio: String,
    val birthDate: Long,
    val photos: List<PhotoModel>,
    val searchGender: String,
)