package com.example.core_database_impl.data.mapper

import com.example.core_database_api.data.model.LocalPhotoModel
import com.example.core_database_impl.data.entity.PhotoEntity

internal fun List<PhotoEntity>.toDomainPhotoList(): List<LocalPhotoModel> {
    return this.map {
        LocalPhotoModel(
            photoId = it.photoId,
            photoUrl = it.photoUrl,
            photoNumber = it.photoNumber,
            userCreatorId = it.userCreatorId,
        )
    }
}
