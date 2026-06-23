package com.example.core_backendless_api.usecase.photo

import com.example.core_backendless_api.model.PhotoModel

interface DeletePhotosUseCase {

    suspend operator fun invoke (photos: List<PhotoModel>, userId: String)

}