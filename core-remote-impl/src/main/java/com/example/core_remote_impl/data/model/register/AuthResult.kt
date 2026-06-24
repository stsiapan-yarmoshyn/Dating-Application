package com.example.core_remote_impl.data.model.register

import com.google.gson.annotations.SerializedName

data class AuthResult(
    @SerializedName("success") val success: Boolean,
    @SerializedName("objectId") val objectId: String? = null,
    @SerializedName("code") val errorCode: Int? = null,
    @SerializedName("message") val errorMessage: String? = null
)