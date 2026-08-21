package com.example.core_remote_impl.data.network

import com.example.core_database_api.data.repository.SessionManager
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.http.HttpStatusCode
import io.ktor.http.encodedPath

val BackendlessAuthPlugin = createClientPlugin("BackendlessAuthPlugin", ::AuthPluginConfig) {
    val sessionManager = pluginConfig.sessionManager

    onRequest { request, _ ->
        val currentPath = request.url.encodedPath

        if (currentPath.contains("users/isvalidusertoken")) {
            val token = sessionManager?.getUserToken()

            if (!token.isNullOrBlank() && !currentPath.contains(token)) {
                val cleanPath = currentPath.removeSuffix("/")

                request.url.encodedPath = "$cleanPath/$token"
            }
        }

        // TODO check if another requests require token in header
//        else if (!currentPath.contains("loginWithRelations")) {
//            val token = sessionManager?.getUserToken()
//            if (!token.isNullOrBlank()) {
//                request.header("user-token", token)
//            }
//        }
    }

    // 2. Перехватываем ответ сервера для отслеживания протухшей сессии (401)
    onResponse { response ->
        if (response.status == HttpStatusCode.Unauthorized) {
            sessionManager?.clearSession()
        }
    }
}

// Вспомогательный класс для передачи зависимостей в плагин
class AuthPluginConfig {
    var sessionManager: SessionManager? = null
}