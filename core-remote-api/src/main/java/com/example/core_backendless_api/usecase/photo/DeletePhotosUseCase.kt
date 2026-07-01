package com.example.core_backendless_api.usecase.photo

import com.example.core_backendless_api.model.RemotePhotoModel

interface DeletePhotosUseCase {

    suspend operator fun invoke (photos: List<RemotePhotoModel>, userId: String)

}