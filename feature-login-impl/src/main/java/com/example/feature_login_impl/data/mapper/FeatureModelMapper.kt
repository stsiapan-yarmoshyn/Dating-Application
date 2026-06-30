package com.example.feature_login_impl.data.mapper

import com.example.feature_login_api.model.UserProfileModel

fun UserProfileModel.toRemoteModel(): RemoteUserProfile {
    return RemoteUserProfile(
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

fun UserProfileModel.toLocalModel(): LocalUserProfile {
    return LocalUserProfile(
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