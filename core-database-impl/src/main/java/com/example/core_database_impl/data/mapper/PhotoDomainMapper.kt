package com.example.core_database_impl.data.mapper

import com.example.core_database_api.data.model.PhotoModel
import com.example.core_database_impl.data.entity.PhotoEntity

fun List<PhotoModel>.toEntityPhotoList(): List<PhotoEntity> {
    return this.map {
        PhotoEntity(
            photoId = it.photoId,
            photoUrl = it.photoUrl,
            photoNumber = it.photoNumber,
            userCreatorId = it.userCreatorId
        )
    }
}
