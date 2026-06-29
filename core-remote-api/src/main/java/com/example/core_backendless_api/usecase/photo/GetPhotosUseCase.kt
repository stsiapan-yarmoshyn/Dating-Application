package com.example.core_backendless_api.usecase.photo

import com.example.core_backendless_api.model.DomainPhotoModel

interface GetPhotosUseCase {

    suspend operator fun invoke (userId: String): List<DomainPhotoModel>

}