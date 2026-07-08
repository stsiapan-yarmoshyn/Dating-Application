package com.example.core_remote_api.model

data class RemoteUserProfileModel(
    val name: String,
    val gender: String,
    val email: String,
    val password: String = "",
    val bio: String,
    val birthDate: Long,
    val photos: List<RemotePhotoModel>,
    val searchGender: String,
    val lastLogin: Long? = null,
    val created: Long? = null,
)
