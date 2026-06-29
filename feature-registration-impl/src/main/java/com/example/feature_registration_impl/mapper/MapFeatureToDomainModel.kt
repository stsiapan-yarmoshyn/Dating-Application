package com.example.feature_registration_impl.mapper

import com.example.feature_registration_api.model.UserProfileModel

fun UserProfileModel.toDomain(): DomainUserProfile {
    return DomainUserProfile(
        name = this.name,
        gender = this.gender,
        searchGender = this.searchGender,
        email = this.email,
        password = this.password,
        bio = this.bio,
        photos = this.photos.mapToDoaminPhotos(),
        birthDate = this.birthDate,
    )
}
