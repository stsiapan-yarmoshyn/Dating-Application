package com.example.core_remote_impl.data.mapper.user

import com.example.core_backendless_api.model.DomainUserProfileModel
import com.example.core_remote_impl.data.mapper.photo.toPhotoModelList
import com.example.core_remote_impl.data.model.UserProfileDto

internal fun UserProfileDto.toUserProfileModel(): DomainUserProfileModel {
    return DomainUserProfileModel(
        name = name,
        gender = gender,
        email = email,
        password = password,
        bio = bio,
        birthDate = birthDate,
        photos = photos.toPhotoModelList(),
        searchGender = searchGender,
        lastLogin = lastLogin,
        created = created,
    )
}