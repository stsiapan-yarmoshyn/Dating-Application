package com.example.feature_registration_impl.data.mapper

import com.example.feature_registration_api.model.RegistrationResultModel

fun RegistartionRespponseModel.toResult(): RegistrationResultModel {
    return RegistrationResultModel(this.userId)
}