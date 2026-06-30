package com.example.feature_login_impl.data.mapper

import com.example.feature_login_api.model.PhotoModel

fun List<PhotoModel>.mapToDomainPhotos(): List<RemotePhotoModel> {
    return this.map { it.toDomain() }
}

fun PhotoModel.toDomain(): RemotePhotoModel {
    return RemotePhotoModel(
        photoUrl = this.photoUrl,
        photoNumber = this.photoNumber,
    )
}