package com.example.core_remote_impl.data.mapper.register

import com.example.core_backendless_api.model.UserProfileModel
import com.example.core_remote_impl.data.model.register.UserProfileAuthDto

fun UserProfileModel.toUserProfileDto(): UserProfileAuthDto {

    return UserProfileAuthDto(
        password = this.password,
        email = this.email,
        gender = this.gender,
        birthDate = this.birthDate,
        bio = this.bio,
        searchGender = this.searchGender,
        name = this.name,
        photos = this.photos.toPhotDtoList()
    )

}