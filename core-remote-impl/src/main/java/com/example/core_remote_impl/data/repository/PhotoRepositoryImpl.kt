package com.example.core_remote_impl.data.repository

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_backendless_api.repository.PhotoRepository

class PhotoRepositoryImpl(): PhotoRepository {

    override suspend fun savePhotosForUser(
        photo: List<PhotoModel>,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getPhotosForUser(userId: String): List<PhotoModel> {
        TODO("Not yet implemented")
    }

    override suspend fun deletePhotosForUser(
        photo: List<PhotoModel>,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

}