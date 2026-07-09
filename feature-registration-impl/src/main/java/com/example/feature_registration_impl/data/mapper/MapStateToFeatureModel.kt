package com.example.feature_registration_impl.data.mapper

import com.example.feature_registration_api.model.PhotoModel
import com.example.feature_registration_api.model.UserProfileModel
import com.example.feature_registration_impl.screen.RegistrationUiState

fun RegistrationUiState.toFeatureModel(): UserProfileModel {
    return UserProfileModel(
        name = this.name,
        gender = this.gender,
        searchGender = this.searchGender,
        email = this.email,
        password = this.password,
        bio = this.aboutMe,
        photos = this.photoUrls.mapIndexed { index, url -> PhotoModel(url, index + 1) },
        birthDate = this.birthDateMillis ?: 0,
    )
}