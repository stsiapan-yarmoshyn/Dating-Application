package com.example.core_backendless_api.repository

import com.example.core_backendless_api.model.RemotePhotoModel
import com.example.core_backendless_api.model.RemoteUserProfileModel

interface PhotoRepository {

    suspend fun appendPhotosForUser(photos: List<RemotePhotoModel>, userId: String): Result<RemoteUserProfileModel>

    suspend fun getPhotosForUser(userId: String): List<RemotePhotoModel>

    suspend fun deletePhotosForUser(photos: List<RemotePhotoModel>, userId: String)

}