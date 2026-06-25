package com.example.core_remote_impl.data.repository

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_backendless_api.repository.PhotoRepository
import com.example.core_remote_impl.data.mapper.photo.toAppendRequest
import com.example.core_remote_impl.data.network.PhotoApi
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoApi: PhotoApi
) : PhotoRepository {

    override suspend fun appendPhotosForUser(
        photos: List<PhotoModel>,
        userId: String
    ) {
        photoApi.appendPhotosToUser(photos.toAppendRequest(userId))
    }

    override suspend fun getPhotosForUser(userId: String): List<PhotoModel> {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhotosForUser(
        photos: List<PhotoModel>,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

}