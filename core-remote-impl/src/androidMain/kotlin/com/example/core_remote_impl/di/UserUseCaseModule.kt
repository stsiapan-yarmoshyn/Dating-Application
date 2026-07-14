package com.example.core_remote_impl.di

import com.example.core_remote_api.repository.UserRepository
import com.example.core_remote_api.usecase.user.AuthenticateUserUseCase
import com.example.core_remote_api.usecase.user.DeleteUserUseCase
import com.example.core_remote_api.usecase.user.GetMatchingUsersUseCase
import com.example.core_remote_api.usecase.user.RegisterUserUseCase
import com.example.core_remote_impl.usecase.user.AuthenticateUserUseCaseImpl
import com.example.core_remote_impl.usecase.user.DeleteUserUseCaseImpl
import com.example.core_remote_impl.usecase.user.GetMatchingUsersUseCaseImpl
import com.example.core_remote_impl.usecase.user.RegisterUserUseCaseImpl
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
    fun provideAuthenticateUserUseCase(
        userRepository: UserRepository
    ): AuthenticateUserUseCase {
        return AuthenticateUserUseCaseImpl(userRepository)
    }

    @Singleton
    @Provides
    fun provideRegisterUserUseCase(
        userRepository: UserRepository
    ): RegisterUserUseCase {
        return RegisterUserUseCaseImpl(userRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteUserUseCase(
        userRepository: UserRepository
    ): DeleteUserUseCase{
        return DeleteUserUseCaseImpl(userRepository)
    }

    @Singleton
    @Provides
    fun provideGetMatchingUsersUseCase(
        userRepository: UserRepository
    ): GetMatchingUsersUseCase {
        return GetMatchingUsersUseCaseImpl(userRepository)
    }



}