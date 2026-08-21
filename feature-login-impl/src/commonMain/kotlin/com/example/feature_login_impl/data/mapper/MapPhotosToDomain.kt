package com.example.feature_login_impl.data.mapper

import com.example.core_database_api.data.model.LocalPhotoModel
import com.example.feature_login_api.model.PhotoModel

fun List<PhotoModel>.mapToDomainPhotos(): List<LocalPhotoModel> {
    return this.map { it.toDomain() }
}

fun PhotoModel.toDomain(): LocalPhotoModel {
    return LocalPhotoModel(
        photoUrl = this.photoUrl,
        photoNumber = this.photoNumber,
        userCreatorId = this.userCreatorId,
        photoId = this.photoId
    )
}