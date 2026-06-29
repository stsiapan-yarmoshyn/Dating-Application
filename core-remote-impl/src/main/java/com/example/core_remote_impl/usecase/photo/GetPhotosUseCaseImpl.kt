package com.example.core_remote_impl.usecase.photo

import com.example.core_backendless_api.model.DomainPhotoModel
import com.example.core_backendless_api.repository.PhotoRepository
import com.example.core_backendless_api.usecase.photo.GetPhotosUseCase
import javax.inject.Inject

internal class GetPhotosUseCaseImpl @Inject constructor(
    private val photoRepository: PhotoRepository
) : GetPhotosUseCase {

    override suspend operator fun invoke(userId: String): List<DomainPhotoModel> {
        return photoRepository.getPhotosForUser(userId)
    }

}