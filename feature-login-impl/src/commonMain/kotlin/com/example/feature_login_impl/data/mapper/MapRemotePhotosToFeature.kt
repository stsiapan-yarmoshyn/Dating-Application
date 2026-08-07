package com.example.feature_login_impl.data.mapper

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.feature_login_api.model.PhotoModel

fun List<RemotePhotoModel>.mapToFeaturePhotos(): List<PhotoModel> {
    return this.map { photo -> photo.mapToFeatureModel() }
}

fun RemotePhotoModel.mapToFeatureModel(): PhotoModel {
    return PhotoModel(
        photoId = this.photoId,
        photoUrl = this.photoUrl,
        photoNumber = this.photoNumber,
        userCreatorId = this.userCreatorId,
    )
}