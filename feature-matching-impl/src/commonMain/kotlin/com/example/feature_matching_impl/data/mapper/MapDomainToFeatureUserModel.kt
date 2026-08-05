package com.example.feature_matching_impl.data.mapper

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.feature_matching_api.model.UserProfileModel

fun LocalUserProfileModel.toFeatureProfile(): UserProfileModel {
    return UserProfileModel(
        userId = this.userId,
        name = this.name,
        gender = this.gender,
        searchGender = this.searchGender,
        email = this.email,
        bio = this.bio,
        photos = photos.toFeaturePhotos(),
        birthDate = this.birthDate,
    )
}