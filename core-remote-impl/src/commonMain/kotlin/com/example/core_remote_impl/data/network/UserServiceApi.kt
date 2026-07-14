package com.example.core_remote_impl.data.network

import com.example.core_remote_impl.data.model.UserRequestDto
import com.example.core_remote_impl.data.model.UserResponseDto
import com.example.core_remote_impl.data.model.auth.LoginData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

internal class UserServiceApi(
    private val client: HttpClient,
    private val baseUrl: String
) {

    // 1. PUT запрос с телом
    suspend fun executeRegisterUserTransaction(request: UserRequestDto): UserResponseDto {
        return client.put("$baseUrl/api/data/Users/deep-save") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    //TODO get from headers 'user-token' value
    // 2. POST запрос с телом
    suspend fun loginUser(request: LoginData): UserResponseDto {
        return client.post("$baseUrl/api/services/AuthService/loginWithRelations") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    // 3. GET запрос с Query-параметрами
    suspend fun getMatchingUser(
        whereClause: String,
        pageSize: Int,
        offset: Int
    ): List<UserResponseDto> {
        return client.get("$baseUrl/api/data/Users") {
            url {
                parameters.append("where", whereClause)
                parameters.append("pageSize", pageSize.toString())
                parameters.append("offset", offset.toString())
            }
        }.body()
    }

    // 4. DELETE запрос с Path-переменной
    suspend fun deleteUser(id: String) {
        client.delete("$baseUrl/api/data/Users/$id")
    }
}