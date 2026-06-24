package com.example.core_remote_impl.data.model.auth

import com.google.gson.annotations.SerializedName

data class UserProfileDto(
    @SerializedName("password") val password: String,
    @SerializedName("email") val email: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("birth_date") val birthDate: Long,
    @SerializedName("bio") val bio: String,
    @SerializedName("search_gender") val searchGender: String,
    @SerializedName("name") val name: String,
    @SerializedName("photos") val photos: List<PhotoDto>,
)