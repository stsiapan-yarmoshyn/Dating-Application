package com.example.feature_registration_impl.di

import com.example.core_remote_api.usecase.user.RegisterUserUseCase
import com.example.feature_registration_api.usecase.FeatureRegistrationUseCase
import com.example.feature_registration_impl.data.usecase.FeatureRegisterUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideFeatureRegisterUserUseCase(
        registerUserUseCase: RegisterUserUseCase
    ): FeatureRegistrationUseCase {
        return FeatureRegisterUserUseCaseImpl(registerUserUseCase)
    }

}