package com.example.core_remote_impl.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotoDto(
    @SerialName("objectId") val photoId: String,
    @SerialName("photo_url") val photoUrl: String,
    @SerialName("order_index") val orderIndex: Int,
)