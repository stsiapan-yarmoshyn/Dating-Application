package com.example.core_remote_impl.data.network

import com.example.core_remote_impl.data.model.UserRequestDto
import com.example.core_remote_impl.data.model.UserResponseDto
import com.example.core_remote_impl.data.model.auth.LoginData
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

internal interface UserServiceApi {

    @PUT("api/data/Users/deep-save")
    suspend fun executeRegisterUserTransaction(
        @Body request: UserRequestDto
    ): UserResponseDto

    //TODO get from headers 'user-token' value
    @POST("api/services/AuthService/loginWithRelations")
    suspend fun loginUser(
        @Body request: LoginData
    ): UserResponseDto

    @DELETE("api/data/Users/{objectId}")
    suspend fun deleteUser(
        @Path("objectId") id: String
    )
}