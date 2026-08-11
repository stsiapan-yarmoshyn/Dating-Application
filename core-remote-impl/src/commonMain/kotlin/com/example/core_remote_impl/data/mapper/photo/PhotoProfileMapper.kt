package com.example.core_remote_impl.data.mapper.photo

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.core_remote_impl.data.model.PhotoDto

internal fun RemotePhotoModel.toPhotDto(orderIndex: Int): PhotoDto {
    return PhotoDto(
        photoId = this.photoId,
        photoUrl = this.photoUrl,
        orderIndex = orderIndex,
    )
}

internal fun List<RemotePhotoModel>.toPhotDtoList(): List<PhotoDto> {
    return this.mapIndexed { index, photoModel ->
        photoModel.toPhotDto(index)
    }
}