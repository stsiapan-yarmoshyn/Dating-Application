package com.example.core_remote_impl.di

import com.example.core_remote_api.repository.PhotoRepository
import com.example.core_remote_api.usecase.photo.AppendPhotosUseCase
import com.example.core_remote_api.usecase.photo.DeletePhotosUseCase
import com.example.core_remote_api.usecase.photo.GetPhotosUseCase
import com.example.core_remote_impl.usecase.photo.AppendPhotosUseCaseImpl
import com.example.core_remote_impl.usecase.photo.DeletePhotosUseCaseImpl
import com.example.core_remote_impl.usecase.photo.GetPhotosUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotoUseCaseModule {

    @Singleton
    @Provides
    fun provideAppendPhotosUseCase(
        photoRepository: PhotoRepository
    ): AppendPhotosUseCase {
        return AppendPhotosUseCaseImpl(photoRepository)
    }

    @Singleton
    @Provides
    fun provideDeletePhotoUseCase(
        photoRepository: PhotoRepository
    ): DeletePhotosUseCase {
        return DeletePhotosUseCaseImpl(photoRepository)
    }

    @Singleton
    @Provides
    fun provideGetPhotosUseCase(
        photoRepository: PhotoRepository
    ): GetPhotosUseCase {
        return GetPhotosUseCaseImpl(photoRepository)
    }


}