package com.example.core_remote_impl.data.model

import com.google.gson.annotations.SerializedName

internal data class UserResponseDto(
    @SerializedName("password") val password: String,
    @SerializedName("email") val email: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("birth_date") val birthDate: Long,
    @SerializedName("bio") val bio: String,
    @SerializedName("search_gender") val searchGender: String,
    @SerializedName("name") val name: String,
    @SerializedName("photos") val photos: List<PhotoDto>,
    @SerializedName("objectId") val userId: String,
    @SerializedName("lastLogin") val lastLogin: Long,
    @SerializedName("userStatus") val userStatus: String,
    @SerializedName("created") val created: Long,
    @SerializedName("oAuthIdentities") val oAuthIdentities: Any? = null, //TODO implement in future
    @SerializedName("location") val location: Any? = null, //TODO implement in future
)