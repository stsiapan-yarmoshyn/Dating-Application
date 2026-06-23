package com.example.core_remote_impl.usecase.photo

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_backendless_api.repository.PhotoRepository
import com.example.core_backendless_api.usecase.photo.SavePhotosUseCase
import javax.inject.Inject

internal class SavePhotosUseCaseImpl @Inject constructor(
    private val photoRepository: PhotoRepository
): SavePhotosUseCase {

    override suspend fun invoke(
        photos: List<PhotoModel>,
        userId: String,
    ) {
        photoRepository.savePhotosForUser(photos, userId)
    }

}