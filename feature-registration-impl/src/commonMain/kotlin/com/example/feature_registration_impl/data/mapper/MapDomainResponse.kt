package com.example.feature_registration_impl.data.mapper

import com.example.core_remote_api.model.RegistrationResponseModel
import com.example.feature_registration_api.model.RegistrationData

fun RegistrationResponseModel.toFeatureData(): RegistrationData {
    return RegistrationData(this.userId)
}