package com.example.core_backendless_api.repository

import com.example.core_backendless_api.model.PhotoModel
import com.example.core_backendless_api.model.UserProfileModel

interface PhotoRepository {

    suspend fun appendPhotosForUser(photos: List<PhotoModel>, userId: String): Result<UserProfileModel>

    suspend fun getPhotosForUser(userId: String): List<PhotoModel>

    suspend fun deletePhotosForUser(photos: List<PhotoModel>, userId: String)

}