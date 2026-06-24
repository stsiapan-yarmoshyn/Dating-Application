package com.example.core_remote_impl.data.model.register

import com.google.gson.annotations.SerializedName

data class PhotoAuthDto(
    @SerializedName("photo_url") val photoUrl: String,
    @SerializedName("order_index") val orderIndex: Int,
)