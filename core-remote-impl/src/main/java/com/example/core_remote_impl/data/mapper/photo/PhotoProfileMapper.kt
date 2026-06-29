package com.example.core_remote_impl.data.mapper.photo

import com.example.core_backendless_api.model.DomainPhotoModel
import com.example.core_remote_impl.data.model.PhotoDto

fun DomainPhotoModel.toPhotDtoList(orderIndex: Int): PhotoDto {
    return PhotoDto(
        photoUrl = this.photoUrl,
        orderIndex = orderIndex,
    )
}

fun List<DomainPhotoModel>.toPhotDtoList(): List<PhotoDto> {
    return this.mapIndexed { index, photoModel ->
        photoModel.toPhotDtoList(index)
    }
}