package com.example.core_remote_impl.usecase.photo

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.core_remote_api.repository.PhotoRepository
import com.example.core_remote_api.usecase.photo.AppendPhotosUseCase

internal class AppendPhotosUseCaseImpl(
    private val photoRepository: PhotoRepository
): AppendPhotosUseCase {

    override suspend operator fun invoke(
        photos: List<RemotePhotoModel>,
        userId: String,
    ): Result<RemoteUserProfileModel> {
        return photoRepository.appendPhotosForUser(photos, userId)
    }

}