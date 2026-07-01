package com.example.core_remote_impl.data.mapper.photo

import com.example.core_backendless_api.model.RemotePhotoModel
import com.example.core_remote_impl.data.model.PhotoDto

internal fun PhotoDto.toPhotoModel(): RemotePhotoModel {
    return RemotePhotoModel(
        photoUrl = this.photoUrl,
        photoNumber = this.orderIndex,
    )
}

internal fun List<PhotoDto>.toPhotoModelList(): List<RemotePhotoModel> {
    return this.map { it.toPhotoModel() }
}