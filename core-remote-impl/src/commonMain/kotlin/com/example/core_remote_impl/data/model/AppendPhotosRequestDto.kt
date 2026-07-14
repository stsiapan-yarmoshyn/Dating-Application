package com.example.core_remote_impl.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AppendPhotosRequestDto(
    @SerialName("objectId") val userId: String,
    @SerialName("photos") val photos: List<PhotoDto>,
)
