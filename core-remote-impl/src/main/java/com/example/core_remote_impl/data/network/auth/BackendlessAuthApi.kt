package com.example.core_remote_impl.data.network.auth

import com.example.core_remote_impl.data.model.auth.AuthResult
import com.example.core_remote_impl.data.model.auth.UserProfileDto
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface BackendlessAuthApi {

    @PUT("api/data/Users/deep-save")
    suspend fun executeTransaction(
        @Body request: UserProfileDto
    ): Result<AuthResult>


}