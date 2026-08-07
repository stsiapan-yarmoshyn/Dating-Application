package com.example.core_remote_api.repository

import com.example.core_remote_api.model.RemotePhotoModel
import com.example.core_remote_api.model.RemoteUserProfileModel

interface RemotePhotoRepository {

    suspend fun appendPhotosForUser(photos: List<RemotePhotoModel>, userId: String): Result<RemoteUserProfileModel>

    suspend fun getPhotosForUser(userId: String): List<RemotePhotoModel>

    suspend fun deletePhotosForUser(photos: List<RemotePhotoModel>, userId: String)

}