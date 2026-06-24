package com.example.core_remote_impl.data.mapper.auth

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_remote_impl.data.model.auth.PhotoDto

fun PhotoModel.toPhotDtoList(orderIndex: Int): PhotoDto {
    return PhotoDto(
        photoUrl = this.photoUrl,
        orderIndex = orderIndex,
    )
}

fun List<PhotoModel>.toPhotDtoList(): List<PhotoDto> {
    return this.mapIndexed { index, photoModel ->
        photoModel.toPhotDtoList(index)
    }
}