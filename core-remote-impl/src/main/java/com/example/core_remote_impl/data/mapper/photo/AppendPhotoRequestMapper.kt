package com.example.core_remote_impl.data.mapper.photo

import com.example.core_backendless_api.model.RemotePhotoModel
import com.example.core_remote_impl.data.model.AppendPhotosRequestDto

internal fun List<RemotePhotoModel>.toAppendRequest(userId: String): AppendPhotosRequestDto {
    return AppendPhotosRequestDto(
        photos = this.toPhotDtoList(),
        userId = userId,
    )
}