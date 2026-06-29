package com.example.core_remote_impl.data.mapper.user

import com.example.core_backendless_api.model.RegistrationResponseModel
import com.example.core_remote_impl.data.model.UserProfileDto

internal fun UserProfileDto.toRegisterResponse(): RegistrationResponseModel {
    return RegistrationResponseModel(
        userId = userId ?: "",
    )
}