package com.example.feature_registration_impl.data.mapper

import com.example.core_remote_api.model.RemoteUserProfileModel
import com.example.feature_registration_api.model.UserProfileModel

//TODO rework mapper and rework core-api response model

fun RemoteUserProfileModel.toFeatureProfile(): UserProfileModel{
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