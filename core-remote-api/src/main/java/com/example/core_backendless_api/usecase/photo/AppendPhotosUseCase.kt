package com.example.core_backendless_api.usecase.photo

import com.example.core_backendless_api.model.RemotePhotoModel
import com.example.core_backendless_api.model.RemoteUserProfileModel

interface AppendPhotosUseCase {

    suspend operator fun invoke (photos: List<RemotePhotoModel>, userId: String): Result<RemoteUserProfileModel>

}