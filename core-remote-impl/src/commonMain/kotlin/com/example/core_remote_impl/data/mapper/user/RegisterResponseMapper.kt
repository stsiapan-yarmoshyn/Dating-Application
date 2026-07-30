package com.example.core_remote_impl.data.mapper.user

import com.example.core_remote_api.model.RegistrationResponseModel
import com.example.core_remote_impl.data.model.UserResponseDto

internal fun UserResponseDto.toRegisterResponse(): RegistrationResponseModel {
    return RegistrationResponseModel(
        userId = userId,
    )
}