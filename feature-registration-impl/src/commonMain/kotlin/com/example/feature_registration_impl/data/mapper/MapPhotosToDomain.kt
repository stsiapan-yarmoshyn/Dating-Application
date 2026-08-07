package com.example.feature_registration_impl.data.mapper

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.feature_registration_api.model.PhotoModel

fun List<PhotoModel>.mapToDomainPhotos(): List<RemotePhotoModel> {
    return this.map { it.toDomain() }
}

fun PhotoModel.toDomain(): RemotePhotoModel {
    return RemotePhotoModel(
        photoUrl = this.photoUrl,
        photoNumber = this.photoNumber,
    )
}