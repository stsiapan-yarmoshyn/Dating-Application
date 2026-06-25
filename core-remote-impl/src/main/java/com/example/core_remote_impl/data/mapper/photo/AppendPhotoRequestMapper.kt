package com.example.core_remote_impl.data.mapper.photo

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_remote_impl.data.model.AppendPhotosRequestDto

fun List<PhotoModel>.toAppendRequest(userId: String): AppendPhotosRequestDto {
    return AppendPhotosRequestDto(
        photos = this.toPhotDtoList(),
        userId = userId,
    )
}