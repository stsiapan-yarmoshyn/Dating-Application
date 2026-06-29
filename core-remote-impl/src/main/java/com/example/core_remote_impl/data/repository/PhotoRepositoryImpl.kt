package com.example.core_remote_impl.data.repository

import com.example.core_backendless_api.model.DomainPhotoModel
import com.example.core_backendless_api.model.DomainUserProfileModel
import com.example.core_backendless_api.repository.PhotoRepository
import com.example.core_remote_impl.data.mapper.photo.toAppendRequest
import com.example.core_remote_impl.data.mapper.user.toUserProfileModel
import com.example.core_remote_impl.data.network.PhotoApi
import javax.inject.Inject

internal class PhotoRepositoryImpl @Inject constructor(
    private val photoApi: PhotoApi
) : PhotoRepository {

    override suspend fun appendPhotosForUser(
        photos: List<DomainPhotoModel>,
        userId: String
    ): Result<DomainUserProfileModel> {
        return runCatching {
            val result = photoApi.appendPhotosToUser(photos.toAppendRequest(userId))
            result.toUserProfileModel()
        }
    }

    override suspend fun getPhotosForUser(userId: String): List<DomainPhotoModel> {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhotosForUser(
        photos: List<DomainPhotoModel>,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

}