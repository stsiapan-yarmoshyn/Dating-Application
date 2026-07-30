package com.example.feature_registration_impl.data.mapper

import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.feature_registration_api.model.UserProfileModel

fun UserProfileModel.toDomain(): RemoteUserProfileModel {
    return RemoteUserProfileModel(
        name = this.name,
        gender = this.gender,
        searchGender = this.searchGender,
        email = this.email,
        password = this.password,
        bio = this.bio,
        photos = this.photos.mapToDomainPhotos(),
        birthDate = this.birthDate,
    )
}
