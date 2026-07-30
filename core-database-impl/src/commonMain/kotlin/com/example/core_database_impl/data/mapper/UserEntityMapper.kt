package com.example.core_database_impl.data.mapper

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.core_database_impl.data.entity.relation.UserWithPhotos

internal fun UserWithPhotos.toDomain(): LocalUserProfileModel {
    return LocalUserProfileModel(
        email = this.user.email,
        name = this.user.name,
        gender = this.user.gender,
        bio = this.user.bio,
        birthDate = this.user.birthDate,
        photos = this.photos.toDomainPhotoList(),
        searchGender = this.user.searchGender,
        userId = this.user.userId,
    )
}

internal fun List<UserWithPhotos>.toDomainList(): List<LocalUserProfileModel> {
    return this.map { entity -> entity.toDomain() }
}