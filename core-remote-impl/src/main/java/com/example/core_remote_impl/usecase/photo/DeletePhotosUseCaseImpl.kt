package com.example.core_remote_impl.usecase.photo

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.core_remote_api.repository.RemotePhotoRepository
import com.example.core_remote_api.usecase.photo.DeletePhotosUseCase
import javax.inject.Inject

internal class DeletePhotosUseCaseImpl @Inject constructor(
    private val photoRepository: RemotePhotoRepository
) : DeletePhotosUseCase {

    override suspend operator fun invoke(
        photos: List<RemotePhotoModel>,
        userId: String,
    ) {
        photoRepository.deletePhotosForUser(photos, userId)
    }

}