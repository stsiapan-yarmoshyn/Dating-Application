package com.example.core_remote_impl.di

import com.example.core_remote_api.repository.PhotoRepository
import com.example.core_remote_api.repository.UserRepository
import com.example.core_remote_impl.data.network.PhotoApi
import com.example.core_remote_impl.data.network.UserServiceApi
import com.example.core_remote_impl.data.repository.PhotoRepositoryImpl
import com.example.core_remote_impl.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(userServiceApi: UserServiceApi): UserRepository {
        return UserRepositoryImpl(userServiceApi) // Обычный вызов конструктора
    }

    @Singleton
    @Provides
    fun providePhotoRepository(photoApi: PhotoApi): PhotoRepository {
        return PhotoRepositoryImpl(photoApi)
    }

}