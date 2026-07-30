package com.example.core_remote_impl.data.network

import com.example.core_remote_impl.BuildKonfig
import io.ktor.client.*
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun createKtorClient(engine: HttpClientEngine): HttpClient {
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
    }
}