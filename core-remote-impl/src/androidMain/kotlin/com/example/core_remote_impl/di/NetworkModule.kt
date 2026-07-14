package com.example.core_remote_impl.di

//import com.example.core_remote_impl.BuildConfig
import com.example.core_remote_impl.BuildConfig
import com.example.core_remote_impl.data.network.PhotoApi
import com.example.core_remote_impl.data.network.UserServiceApi
import com.example.core_remote_impl.data.network.createKtorClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.engine.okhttp.OkHttp.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    // 1. Hilt создает Ktor-сервис (который мы написали в commonMain)
    @Singleton
    @Provides
    fun provideUserServiceApi(): UserServiceApi {
        val client = createKtorClient(
            create()
        )
        return UserServiceApi(client, baseUrl = BuildConfig.BACKENDLESS_BASE_URL)
    }

    @Singleton
    @Provides
    fun providePhotoApi(): PhotoApi {
        val client = createKtorClient(
            create()
        )
        return PhotoApi(client, baseUrl = BuildConfig.BACKENDLESS_BASE_URL)
    }

}