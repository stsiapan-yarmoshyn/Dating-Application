package com.example.core_database_impl.data.mapper

import com.example.core_database_api.data.model.UserProfileModel
import com.example.core_database_impl.data.entity.UserProfileEntity

fun UserProfileModel.toEntity(): UserProfileEntity {
    return UserProfileEntity(
        email = this.email,
        name = this.name,
        gender = this.gender,
        age = this.age,
        bio = this.bio,
        birthDate = this.birthDate,
        photos = this.photos,
        searchGender = this.searchGender,
        userId = this.userId,
    )
}