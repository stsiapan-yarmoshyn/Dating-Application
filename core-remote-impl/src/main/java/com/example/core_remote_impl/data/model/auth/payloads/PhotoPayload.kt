package com.example.core_remote_impl.data.model.auth.payloads

import com.example.core_backendless_api.model.Payload
import com.google.gson.annotations.SerializedName

data class PhotoPayload(
    @SerializedName("photo_url") val photoUrl: String,
    @SerializedName("order_index") val orderIndex: Int,
): Payload