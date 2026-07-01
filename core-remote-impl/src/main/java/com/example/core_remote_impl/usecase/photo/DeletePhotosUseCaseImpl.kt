package com.example.core_remote_impl.usecase.photo

import com.example.core_backendless_api.model.RemotePhotoModel
import com.example.core_backendless_api.repository.PhotoRepository
import com.example.core_backendless_api.usecase.photo.DeletePhotosUseCase
import javax.inject.Inject

internal class DeletePhotosUseCaseImpl @Inject constructor(
    private val photoRepository: PhotoRepository
) : DeletePhotosUseCase {

    override suspend operator fun invoke(
        photos: List<RemotePhotoModel>,
        userId: String,
    ) {
        photoRepository.deletePhotosForUser(photos, userId)
    }

}