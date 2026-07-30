package com.example.core_remote_impl.data.mapper.photo

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.core_remote_impl.data.model.PhotoDto

internal fun RemotePhotoModel.toPhotDtoList(orderIndex: Int): PhotoDto {
    return PhotoDto(
        photoUrl = this.photoUrl,
        orderIndex = orderIndex,
    )
}

internal fun List<RemotePhotoModel>.toPhotDtoList(): List<PhotoDto> {
    return this.mapIndexed { index, photoModel ->
        photoModel.toPhotDtoList(index)
    }
}