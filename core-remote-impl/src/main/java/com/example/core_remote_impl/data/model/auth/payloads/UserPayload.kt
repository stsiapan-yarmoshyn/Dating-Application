package com.example.core_remote_impl.data.model.auth.payloads

import com.example.core_backendless_api.model.Payload
import com.google.gson.annotations.SerializedName

data class UserPayload(
    @SerializedName("password") val password: String,
    @SerializedName("email") val email: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("birth_date") val birthDate: Long,
    @SerializedName("bio") val bio: String,
    @SerializedName("search_gender") val searchGender: String,
    @SerializedName("name") val name: String,
): Payload