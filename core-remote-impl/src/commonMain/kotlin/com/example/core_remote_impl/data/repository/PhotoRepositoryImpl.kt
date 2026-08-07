package com.example.core_remote_impl.data.repository

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.core_remote_api.repository.RemotePhotoRepository
import com.example.core_remote_impl.data.mapper.photo.toAppendRequest
import com.example.core_remote_impl.data.mapper.user.toUserProfileModel
import com.example.core_remote_impl.data.network.PhotoApi

internal class PhotoRepositoryImpl(
    private val photoApi: PhotoApi
) : RemotePhotoRepository {

    override suspend fun appendPhotosForUser(
        photos: List<RemotePhotoModel>,
        userId: String
    ): Result<RemoteUserProfileModel> {
        return runCatching {
            val result = photoApi.appendPhotosToUser(photos.toAppendRequest(userId))
            result.toUserProfileModel()
        }
    }

    override suspend fun getPhotosForUser(userId: String): List<RemotePhotoModel> {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhotosForUser(
        photos: List<RemotePhotoModel>,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

}