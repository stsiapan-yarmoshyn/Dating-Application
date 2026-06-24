package com.example.core_remote_impl.data.mapper.register

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_remote_impl.data.model.register.PhotoAuthDto

fun PhotoModel.toPhotDtoList(orderIndex: Int): PhotoAuthDto {
    return PhotoAuthDto(
        photoUrl = this.photoUrl,
        orderIndex = orderIndex,
    )
}

fun List<PhotoModel>.toPhotDtoList(): List<PhotoAuthDto> {
    return this.mapIndexed { index, photoModel ->
        photoModel.toPhotDtoList(index)
    }
}