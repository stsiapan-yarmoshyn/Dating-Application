package com.example.core_remote_impl.usecase.photo

import com.example.core_backendless_api.model.DomainPhotoModel
import com.example.core_backendless_api.model.DomainUserProfileModel
import com.example.core_backendless_api.repository.PhotoRepository
import com.example.core_backendless_api.usecase.photo.AppendPhotosUseCase
import javax.inject.Inject

internal class AppendPhotosUseCaseImpl @Inject constructor(
    private val photoRepository: PhotoRepository
): AppendPhotosUseCase {

    override suspend operator fun invoke(
        photos: List<DomainPhotoModel>,
        userId: String,
    ): Result<DomainUserProfileModel> {
        return photoRepository.appendPhotosForUser(photos, userId)
    }

}