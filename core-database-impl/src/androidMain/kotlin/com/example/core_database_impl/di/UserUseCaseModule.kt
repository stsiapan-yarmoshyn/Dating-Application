package com.example.core_database_impl.di

import com.example.core_database_api.data.repository.UserRepository
import com.example.core_database_api.data.usecase.GetUserByEmailUseCase
import com.example.core_database_api.data.usecase.GetUserByIdUseCase
import com.example.core_database_api.data.usecase.SaveUserUseCase
import com.example.core_database_impl.usecase.GetUserByEmailUseCaseImpl
import com.example.core_database_impl.usecase.GetUserByIdUseCaseImpl
import com.example.core_database_impl.usecase.SaveUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserUseCaseModule {

    @Singleton
    @Provides
    fun provideGetUserByEmailUseCase(
        userRepository: UserRepository
    ): GetUserByEmailUseCase {
        return GetUserByEmailUseCaseImpl(userRepository)
    }

    @Singleton
    @Provides
    fun provideGetUserByIdUseCase(
        userRepository: UserRepository
    ): GetUserByIdUseCase {
        return GetUserByIdUseCaseImpl(userRepository)
    }

    @Singleton
    @Provides
    fun provideSaveUserUseCase(
        userRepository: UserRepository
    ): SaveUserUseCase {
        return SaveUserUseCaseImpl(userRepository)
    }

}