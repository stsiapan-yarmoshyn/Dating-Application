package com.example.core_database_impl.data.mapper

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.core_database_impl.data.entity.UserProfileEntity
import com.example.core_database_impl.data.entity.relation.UserWithPhotos

internal fun LocalUserProfileModel.toEntity(
    isCurrentUser: Boolean = false,
    isCachedUser: Boolean = false,
): UserProfileEntity {
    return UserProfileEntity(
        userId = this.userId,
        email = this.email,
        name = this.name,
        gender = this.gender,
        bio = this.bio,
        birthDate = this.birthDate,
        searchGender = this.searchGender,
        isCurrentUser = isCurrentUser,
        isCachedUser = isCachedUser,
    )
}

internal fun LocalUserProfileModel.toEntityWithPhotos(
    isCurrentUser: Boolean = false,
    isCachedUser: Boolean = false,
): UserWithPhotos {
    return UserWithPhotos(
        user = this.toEntity(
            isCurrentUser = isCurrentUser,
            isCachedUser = isCachedUser,
        ),
        photos = this.photos.toEntityPhotoList(),
    )
}

internal fun List<LocalUserProfileModel>.toEntityListWithPhotos(
    isCurrentUser: Boolean = false,
    isCachedUser: Boolean = false,
): List<UserWithPhotos> {
    return this.map { it.toEntityWithPhotos(isCurrentUser, isCachedUser) }
}
