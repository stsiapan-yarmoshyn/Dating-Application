package com.example.core_backendless_api.repository

import com.example.core_backendless_api.model.RemoteUserProfileModel
import com.example.core_backendless_api.model.RegistrationResponseModel

interface UserRepository {

    suspend fun registerUser(user: RemoteUserProfileModel): Result<RegistrationResponseModel>

    suspend fun loginUser(login: String, password: String): Result<RemoteUserProfileModel>

    suspend fun deleteUser(userId: String)

}