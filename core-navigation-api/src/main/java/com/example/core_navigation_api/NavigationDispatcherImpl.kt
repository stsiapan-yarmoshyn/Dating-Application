package com.example.core_navigation_api

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Реализация диспетчера. Скрыта от фич (инжектится через Hilt как Singleton).
 */
class NavigationDispatcherImpl : NavigationDispatcher {

    // extraBufferCapacity = 1 нужен, чтобы метод emit() не блокировал корутину ViewModel,
    // если UI-поток на мгновение занят
    private val _commands = MutableSharedFlow<NavRouterCommand>(extraBufferCapacity = 1)

    override val commands: SharedFlow<NavRouterCommand> = _commands.asSharedFlow()

    override suspend fun emit(command: NavRouterCommand) {
        _commands.emit(command)
    }
}