package com.example.core_remote_impl.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UserRequestDto(
    @SerialName("password") val password: String,
    @SerialName("email") val email: String,
    @SerialName("gender") val gender: String,
    @SerialName("birth_date") val birthDate: Long,
    @SerialName("bio") val bio: String,
    @SerialName("search_gender") val searchGender: String,
    @SerialName("name") val name: String,
    @SerialName("photos") val photos: List<PhotoDto>,
)
