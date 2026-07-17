package com.example.core_navigation_api

import kotlinx.coroutines.flow.SharedFlow


/**
 * Интерфейс диспетчера. Фичи видят только его.
 * Через него они отправляют свои команды.
 */

interface NavigationDispatcher {
    // Поток команд, который будет слушать MainActivity
    val commands: SharedFlow<NavRouterCommand>

    // Метод для отправки команды из ViewModel
    suspend fun emit(command: NavRouterCommand)
}