package com.example.core_remote_impl.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createKtorClient(engine: HttpClientEngine): HttpClient {
    return HttpClient(engine) {
        // Настройка JSON-сериализации (вместо Gson/Moshi)
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
        // Логирование запросов в консоль (вместо HttpLoggingInterceptor)
        install(Logging) {
            level = LogLevel.BODY
        }
    }
}