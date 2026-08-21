package com.example.core_database_api.data.repository

interface SessionManager {
    suspend fun saveUserToken(token: String)
    suspend fun getUserToken(): String?
    suspend fun clearSession()
}