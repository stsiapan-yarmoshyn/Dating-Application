package com.example.core_remote_impl.data.model

import com.google.gson.annotations.SerializedName

internal data class UserProfileDto(
    @SerializedName("password") val password: String,
    @SerializedName("email") val email: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("birth_date") val birthDate: Long,
    @SerializedName("bio") val bio: String,
    @SerializedName("search_gender") val searchGender: String,
    @SerializedName("name") val name: String,
    @SerializedName("photos") val photos: List<PhotoDto>,
    /**
     * This fields using for parse response data
     * */
    @SerializedName("objectId") val userId: String? = null,
    @SerializedName("lastLogin") val lastLogin: Long? = null,
    @SerializedName("userStatus") val userStatus: String? = null,
    @SerializedName("created") val created: Long? = null,
    @SerializedName("oAuthIdentities") val oAuthIdentities: Any? = null, //TODO implement in future
    @SerializedName("location") val location: Any? = null, //TODO implement in future
)