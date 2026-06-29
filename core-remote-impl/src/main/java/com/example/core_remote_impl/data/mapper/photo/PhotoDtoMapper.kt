package com.example.core_remote_impl.data.mapper.photo

import com.example.core_backendless_api.model.DomainPhotoModel
import com.example.core_remote_impl.data.model.PhotoDto

fun PhotoDto.toPhotoModel(): DomainPhotoModel {
    return DomainPhotoModel(
        photoUrl = this.photoUrl,
        photoNumber = this.orderIndex,
    )
}

fun List<PhotoDto>.toPhotoModelList(): List<DomainPhotoModel> {
    return this.map { it.toPhotoModel() }
}