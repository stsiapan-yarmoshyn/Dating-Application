package com.example.core_remote_impl.data.model.auth

import com.google.gson.annotations.SerializedName

internal data class LoginData(
    @SerializedName("login") val email: String,
    @SerializedName("password") val password: String,
)
