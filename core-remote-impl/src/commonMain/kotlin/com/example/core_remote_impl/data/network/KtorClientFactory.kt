package com.example.core_remote_impl.data.network

import com.example.core_database_api.data.repository.SessionManager
import com.example.core_remote_impl.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createKtorClient(
    engine: HttpClientEngine,
    sessionManager: SessionManager
): HttpClient {
    return HttpClient(engine) {
        defaultRequest {
            val baseUrl = BuildKonfig.BACKENDLESS_BASE_URL.let { url ->
                if (url.endsWith("/")) url else "$url/"
            }

            url.takeFrom(baseUrl)
        }
        // Настройка JSON-сериализации (вместо Gson/Moshi)
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
        // Логирование запросов в консоль (вместо HttpLoggingInterceptor)
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println("KtorClient: $message")
                }
            }
            level = LogLevel.BODY
        }

        install(BackendlessAuthPlugin) {
            this.sessionManager = sessionManager
        }
    }
}