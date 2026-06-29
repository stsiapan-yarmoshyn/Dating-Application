package com.example.core_remote_impl.di

import com.example.core_remote_impl.BuildConfig
import com.example.core_remote_impl.data.network.PhotoApi
import com.example.core_remote_impl.data.network.UserServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    //TODO add interceptor

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient().newBuilder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(httpLoggingInterceptor)
            }
        }.build()
    }

    @Singleton
    @Provides
    fun provideBackendlessAuthApi(
        okHttpClient: OkHttpClient,
    ): UserServiceApi {

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BACKENDLESS_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserServiceApi::class.java)

    }

    @Singleton
    @Provides
    fun providePhotoApi(
        okHttpClient: OkHttpClient,
    ): PhotoApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BACKENDLESS_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotoApi::class.java)

    }

}