package com.example.core_remote_impl.data.mapper.photo

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_remote_impl.data.model.PhotoDto

fun PhotoDto.toPhotoModel(): PhotoModel {
    return PhotoModel(
        photoUrl = this.photoUrl,
        photoNumber = this.orderIndex,
    )
}

fun List<PhotoDto>.toPhotoModelList(): List<PhotoModel> {
    return this.map { it.toPhotoModel() }
}