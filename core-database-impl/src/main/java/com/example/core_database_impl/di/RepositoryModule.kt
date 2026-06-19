package com.example.core_database_impl.di

import com.example.core_database_api.data.repository.UserRepositoryApi
import com.example.core_database_impl.data.dao.UserDao
import com.example.core_database_impl.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepositoryApi {
        return UserRepositoryImpl(userDao)
    }

}