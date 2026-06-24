package com.example.core_remote_impl.data.model.auth

data class AuthResult(
    val success: Boolean,
    val objectId: String? = null,
    val errorCode: Int? = null,
    val errorMessage: String? = null
)