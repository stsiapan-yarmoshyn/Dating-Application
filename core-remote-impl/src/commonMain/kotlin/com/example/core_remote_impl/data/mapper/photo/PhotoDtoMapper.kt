package com.example.core_remote_impl.data.mapper.photo

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.core_remote_impl.data.model.PhotoDto

internal fun PhotoDto.toPhotoModel(userId: String): RemotePhotoModel {
    return RemotePhotoModel(
        photoId = this.photoId,
        photoUrl = this.photoUrl,
        photoNumber = this.orderIndex,
        userCreatorId = userId
    )
}

internal fun List<PhotoDto>.toPhotoModelList(userId: String): List<RemotePhotoModel> {
    return this.map { it.toPhotoModel(userId) }
}