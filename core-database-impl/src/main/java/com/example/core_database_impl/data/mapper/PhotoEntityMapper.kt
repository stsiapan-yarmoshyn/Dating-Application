package com.example.core_database_impl.data.mapper

import com.example.core_database_api.data.model.PhotoModel
import com.example.core_database_impl.data.entity.PhotoEntity

internal fun List<PhotoEntity>.toDomainPhotoList(): List<PhotoModel> {
    return this.map {
        PhotoModel(
            photoId = it.photoId,
            photoUrl = it.photoUrl,
            photoNumber = it.photoNumber,
            userCreatorId = it.userCreatorId
        )
    }
}
