package com.example.core_remote_impl.data.network

import com.example.core_remote_impl.data.model.auth.LoginData
import com.example.core_remote_impl.data.model.auth.UserProfileLoginDto
import com.example.core_remote_impl.data.model.register.AuthResult
import com.example.core_remote_impl.data.model.register.UserProfileAuthDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserServiceApi {

    @PUT("api/data/Users/deep-save")
    suspend fun executeRegisterUserTransaction(
        @Body request: UserProfileAuthDto
    ): Result<AuthResult>

    //TODO get from headers 'user-token' value
    @POST("api/services/AuthService/loginWithRelations")
    suspend fun loginUser(
        @Body request: LoginData
    ): Result<UserProfileLoginDto>

    @DELETE("api/data/Users/{objectId}")
    suspend fun deleteUser(
        @Path("objectId") id: String
    )
}