package com.example.core_database_impl.di

import com.example.core_database_api.data.repository.LocalMatchingRepository
import com.example.core_database_api.data.repository.LocalUserRepository
import com.example.core_database_impl.data.dao.MatchingDao
import com.example.core_database_impl.data.dao.UserDao
import com.example.core_database_impl.data.repository.MatchingRepositoryImpl
import com.example.core_database_impl.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): LocalUserRepository {
        return UserRepositoryImpl(userDao)
    }

    @Provides
    @Singleton
    fun provideMatchingRepository(matchingDao: MatchingDao): LocalMatchingRepository {
        return MatchingRepositoryImpl(matchingDao)
    }

}