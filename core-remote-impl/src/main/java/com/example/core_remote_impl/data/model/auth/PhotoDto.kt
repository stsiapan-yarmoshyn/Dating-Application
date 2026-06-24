package com.example.core_remote_impl.data.model.auth

import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("photo_url") val photoUrl: String,
    @SerializedName("order_index") val orderIndex: Int,
)