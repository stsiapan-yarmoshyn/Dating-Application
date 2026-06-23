package com.example.core_remote_impl.data.model.auth

import com.google.gson.annotations.SerializedName

data class BackendlessRef(
    @SerializedName("___ref") val ref: Boolean = true,
    @SerializedName("opResultId") val opResultId: String,
    @SerializedName("propName") val propName: String = "objectId",
)
