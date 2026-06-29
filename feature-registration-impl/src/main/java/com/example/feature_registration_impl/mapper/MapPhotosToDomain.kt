package com.example.feature_registration_impl.mapper

import com.example.feature_registration_api.model.PhotoModel

fun List<PhotoModel>.mapToDoaminPhotos(): List<DomainPhoto> {
    return this.map { it.toDomain() }
}

fun PhotoModel.toDomain(): DomainPhoto {
    return DomainPhoto(
        photoUrl = this.photoUrl,
        photoNumber = this.photoNumber,
    )
}