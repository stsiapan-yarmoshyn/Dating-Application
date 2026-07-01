package com.example.core_backendless_api.usecase.photo

import com.example.core_backendless_api.model.RemotePhotoModel

interface GetPhotosUseCase {

    suspend operator fun invoke (userId: String): List<RemotePhotoModel>

}