package com.example.core_remote_impl.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UserResponseDto(
    @SerialName("email") val email: String,
    @SerialName("gender") val gender: String,
    @SerialName("birth_date") val birthDate: Long,
    @SerialName("bio") val bio: String,
    @SerialName("search_gender") val searchGender: String,
    @SerialName("name") val name: String,
    @SerialName("photos") val photos: List<PhotoDto> = emptyList(),
    @SerialName("objectId") val userId: String,
    @SerialName("lastLogin") val lastLogin: Long? = null,
    @SerialName("userStatus") val userStatus: String? = null,
    @SerialName("created") val created: Long,
    //@SerialName("oAuthIdentities") val oAuthIdentities: Any? = null, //TODO implement in future
    //@SerialName("location") val location: Any? = null, //TODO implement in future
)