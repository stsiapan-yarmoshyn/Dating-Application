package com.example.core_remote_impl.usecase.photo

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.core_remote_api.repository.PhotoRepository
import com.example.core_remote_api.usecase.photo.GetPhotosUseCase

internal class GetPhotosUseCaseImpl(
    private val photoRepository: PhotoRepository
) : GetPhotosUseCase {

    override suspend operator fun invoke(userId: String): List<RemotePhotoModel> {
        return photoRepository.getPhotosForUser(userId)
    }

}