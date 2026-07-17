package com.example.datingapplication.di

import com.example.core_navigation_api.NavigationDispatcher
import com.example.core_navigation_api.NavigationDispatcherImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreNavModule {

    @Provides
    @Singleton
    fun provideNavigationDispatcher(): NavigationDispatcher {
        // Создаем реализацию напрямую.
        // KSP в модуле app без проблем это обработает, так как app видит классы в рантайме
        return NavigationDispatcherImpl()
    }
}