package com.example.core_remote_impl.usecase.photo

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_backendless_api.repository.PhotoRepository
import com.example.core_backendless_api.usecase.photo.AppendPhotosUseCase
import javax.inject.Inject

internal class AppendPhotosUseCaseImpl @Inject constructor(
    private val photoRepository: PhotoRepository
): AppendPhotosUseCase {

    override suspend fun invoke(
        photos: List<PhotoModel>,
        userId: String,
    ) {
        photoRepository.appendPhotosForUser(photos, userId)
    }

}