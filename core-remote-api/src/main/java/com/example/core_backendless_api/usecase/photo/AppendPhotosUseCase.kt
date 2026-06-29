package com.example.core_backendless_api.usecase.photo

import com.example.core_backendless_api.model.DomainPhotoModel
import com.example.core_backendless_api.model.DomainUserProfileModel

interface AppendPhotosUseCase {

    suspend operator fun invoke (photos: List<DomainPhotoModel>, userId: String): Result<DomainUserProfileModel>

}