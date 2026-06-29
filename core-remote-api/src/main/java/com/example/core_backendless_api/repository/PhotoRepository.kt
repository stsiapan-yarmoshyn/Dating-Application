package com.example.core_backendless_api.repository

import com.example.core_backendless_api.model.DomainPhotoModel
import com.example.core_backendless_api.model.DomainUserProfileModel

interface PhotoRepository {

    suspend fun appendPhotosForUser(photos: List<DomainPhotoModel>, userId: String): Result<DomainUserProfileModel>

    suspend fun getPhotosForUser(userId: String): List<DomainPhotoModel>

    suspend fun deletePhotosForUser(photos: List<DomainPhotoModel>, userId: String)

}