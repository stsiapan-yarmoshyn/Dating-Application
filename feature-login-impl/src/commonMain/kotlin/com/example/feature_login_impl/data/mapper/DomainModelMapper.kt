package com.example.feature_login_impl.data.mapper

import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.feature_login_api.model.UserProfileModel

fun RemoteUserProfileModel.toFeatureModel(): UserProfileModel {
    return UserProfileModel(
        userId = this.userId,
        name = this.name,
        gender = this.gender,
        searchGender = this.searchGender,
        email = this.email,
        password = this.password,
        bio = this.bio,
        photos = this.photos.mapToFeaturePhotos(),
        birthDate = this.birthDate,
    )
}