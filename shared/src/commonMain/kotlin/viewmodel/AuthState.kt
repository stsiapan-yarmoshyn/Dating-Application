package viewmodel

sealed interface AuthState {

    object Loading : AuthState        // Показываем Splash (загрузку)
    object Authenticated : AuthState  // Направляем на Главный экран (Мэтчинг)
    object Unauthenticated : AuthState // Направляем на Логин/Регистрацию

}