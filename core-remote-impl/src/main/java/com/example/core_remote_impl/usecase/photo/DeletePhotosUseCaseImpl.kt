package com.example.core_remote_impl.usecase.photo

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_backendless_api.repository.PhotoRepository
import com.example.core_backendless_api.usecase.photo.DeletePhotosUseCase
import javax.inject.Inject

internal class DeletePhotosUseCaseImpl @Inject constructor(
    private val photoRepository: PhotoRepository
) : DeletePhotosUseCase {

    override suspend fun invoke(
        photos: List<PhotoModel>,
        userId: String,
    ) {
        photoRepository.deletePhotosForUser(photos, userId)
    }

}