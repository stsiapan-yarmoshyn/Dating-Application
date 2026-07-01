package com.example.core_remote_impl.data.mapper.user

import com.example.core_backendless_api.model.RemoteUserProfileModel
import com.example.core_remote_impl.data.mapper.photo.toPhotDtoList
import com.example.core_remote_impl.data.model.UserRequestDto
import com.example.core_remote_impl.data.model.UserResponseDto

internal fun RemoteUserProfileModel.toUserRequestDto(): UserRequestDto {

    return UserRequestDto(
        password = this.password,
        email = this.email,
        gender = this.gender,
        birthDate = this.birthDate,
        bio = this.bio,
        searchGender = this.searchGender,
        name = this.name,
        photos = this.photos.toPhotDtoList(),
    )

}