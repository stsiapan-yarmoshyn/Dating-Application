package com.example.core_remote_impl.usecase.photo

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.core_remote_api.repository.PhotoRepository
import com.example.core_remote_api.usecase.photo.DeletePhotosUseCase

internal class DeletePhotosUseCaseImpl(
    private val photoRepository: PhotoRepository
) : DeletePhotosUseCase {

    override suspend operator fun invoke(
        photos: List<RemotePhotoModel>,
        userId: String,
    ) {
        photoRepository.deletePhotosForUser(photos, userId)
    }

}