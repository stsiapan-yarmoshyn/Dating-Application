package com.example.core_remote_impl.data.model.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class LoginData(
    @SerialName("login") val email: String,
    @SerialName("password") val password: String,
)
