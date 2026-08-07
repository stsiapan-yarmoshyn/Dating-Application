package com.example.feature_matching_impl.data.mapper

import com.example.core_database_api.data.model.LocalPhotoModel
import com.example.feature_matching_api.model.PhotoModel

fun List<LocalPhotoModel>.toFeaturePhotos(): List<PhotoModel> {
    return this.map { photo -> photo.toFeaturePhoto() }
}

fun LocalPhotoModel.toFeaturePhoto(): PhotoModel {
    return PhotoModel(
        photoUrl = this.photoUrl,
        photoNumber = this.photoNumber
    )
}