package com.example.core_backendless_api.repository

import com.example.core_backendless_api.model.DomainUserProfileModel
import com.example.core_backendless_api.model.RegistrationResponseModel

interface UserRepository {

    suspend fun registerUser(user: DomainUserProfileModel): Result<RegistrationResponseModel>

    suspend fun loginUser(login: String, password: String): Result<DomainUserProfileModel>

    suspend fun deleteUser(userId: String)

}