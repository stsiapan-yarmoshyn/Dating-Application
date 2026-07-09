package com.example.core_remote_impl.data.network

import com.example.core_remote_impl.data.model.AppendPhotosRequestDto
import com.example.core_remote_impl.data.model.UserResponseDto
import retrofit2.http.Body
import retrofit2.http.PUT

internal interface PhotoApi {

    @PUT("api/data/Users/deep-save")
    suspend fun appendPhotosToUser(
        @Body request: AppendPhotosRequestDto
    ): UserResponseDto

}