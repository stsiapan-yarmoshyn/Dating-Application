package com.example.feature_login_impl.data.mapper

import com.example.feature_login_api.model.UserProfileModel

fun RemoteUserProfile.toFeatureModel(): UserProfileModel {
    return UserProfileModel(
        name = this.name,
        gender = this.gender,
        searchGender = this.searchGender,
        email = this.email,
        password = this.password,
        bio = this.bio,
        photos = emptyList(),
        birthDate = this.birthDate,
    )
}