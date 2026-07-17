package com.example.datingapplication.di

import com.example.datingapplication.navigation.FeatureNavAdapter
import com.example.datingapplication.navigation.RegistrationNavAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object AppNavigationModule {

    @Provides
    @IntoSet // Помещает этот адаптер в глобальный Set<FeatureNavAdapter>
    fun provideRegistrationNavAdapter(): FeatureNavAdapter {
        return RegistrationNavAdapter()
    }
}