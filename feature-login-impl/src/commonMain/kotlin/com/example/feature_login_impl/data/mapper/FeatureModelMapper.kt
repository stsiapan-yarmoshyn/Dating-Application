package com.example.feature_login_impl.data.mapper

import com.example.core_database_api.data.model.LocalUserProfileModel
import com.example.feature_login_api.model.UserProfileModel

//fun UserProfileModel.toRemoteModel(): RemoteUserProfileModel {
//    return RemoteUserProfileModel(
//        userId = this.userId,
//        name = this.name,
//        gender = this.gender,
//        searchGender = this.searchGender,
//        email = this.email,
//        password = this.password,
//        bio = this.bio,
//        photos = this.photos.mapToDomainPhotos(),
//        birthDate = this.birthDate,
//    )
//}

fun UserProfileModel.toLocalModel(): LocalUserProfileModel {
    return LocalUserProfileModel(
        userId = this.userId,
        name = this.name,
        gender = this.gender,
        searchGender = this.searchGender,
        email = this.email,
        bio = this.bio,
        photos = this.photos.mapToDomainPhotos(),
        birthDate = this.birthDate,
    )
}