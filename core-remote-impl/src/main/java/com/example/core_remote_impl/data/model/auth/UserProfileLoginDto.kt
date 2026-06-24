package com.example.core_remote_impl.data.model.auth

import com.google.gson.annotations.SerializedName

data class UserProfileLoginDto(
    @SerializedName("objectId") val userId: String,
    @SerializedName("lastLogin") val lastLogin: Long,
    @SerializedName("userStatus") val userStatus: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("created") val created: Long,
    @SerializedName("accountType") val accountType: String, val birthDate: Long,
    @SerializedName("bio") val bio: String,
    @SerializedName("search_gender") val searchGender: String,
    @SerializedName("photos") val photos: List<PhotoLoginDto>,
    @SerializedName("oAuthIdentities") val oAuthIdentities: Any? = null, //TODO implement in future
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: Any? = null, //TODO implement in future
    @SerializedName("email") val email: String,
)