package com.example.core_backendless_api.repository

import com.example.core_backendless_api.model.PhotoModel

interface PhotoRepository {

    suspend fun appendPhotosForUser(photos: List<PhotoModel>, userId: String)

    suspend fun getPhotosForUser(userId: String): List<PhotoModel>

    suspend fun deletePhotosForUser(photos: List<PhotoModel>, userId: String)

}