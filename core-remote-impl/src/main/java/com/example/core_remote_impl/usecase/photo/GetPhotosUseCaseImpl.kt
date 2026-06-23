package com.example.core_remote_impl.usecase.photo

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_backendless_api.repository.PhotoRepository
import com.example.core_backendless_api.usecase.photo.GetPhotosUseCase
import javax.inject.Inject

internal class GetPhotosUseCaseImpl @Inject constructor(
    private val photoRepository: PhotoRepository
) : GetPhotosUseCase {

    override suspend fun invoke(userId: String): List<PhotoModel> {
        return photoRepository.getPhotosForUser(userId)
    }

}