package com.example.core_remote_impl.data.model

import com.google.gson.annotations.SerializedName

internal data class AppendPhotosRequestDto(
    @SerializedName("objectId") val userId: String,
    @SerializedName("photos") val photos: List<PhotoDto>,
)
