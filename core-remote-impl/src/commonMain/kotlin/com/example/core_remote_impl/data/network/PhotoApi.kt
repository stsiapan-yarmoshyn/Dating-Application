package com.example.core_remote_impl.data.network

import com.example.core_remote_impl.data.model.AppendPhotosRequestDto
import com.example.core_remote_impl.data.model.UserResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
internal class PhotoApi(
    private val client: HttpClient,
    private val baseUrl: String
) {

    // 1. PUT запрос с телом
    suspend fun appendPhotosToUser(request: AppendPhotosRequestDto): UserResponseDto {
        return client.put("$baseUrl/api/data/Users/deep-save") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

}