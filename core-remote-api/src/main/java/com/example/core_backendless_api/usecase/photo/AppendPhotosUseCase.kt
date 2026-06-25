package com.example.core_backendless_api.usecase.photo

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_backendless_api.model.UserProfileModel

interface AppendPhotosUseCase {

    suspend operator fun invoke (photos: List<PhotoModel>, userId: String): Result<UserProfileModel>

}