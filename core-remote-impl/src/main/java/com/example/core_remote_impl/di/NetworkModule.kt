package com.example.core_remote_impl.di

import com.example.core_backendless_api.model.Payload
import com.example.core_remote_impl.data.model.auth.AuthResult
import com.example.core_remote_impl.data.network.auth.BackendlessAuthApi
import com.example.core_remote_impl.data.util.auth.PayloadSerializer
import com.example.core_remote_impl.data.util.auth.AuthResponseDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
object NetworkModule {

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
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Payload::class.java, PayloadSerializer())
            .registerTypeAdapter(AuthResult::class.java, AuthResponseDeserializer())
            .create()
    }

    @Singleton
    @Provides
    fun provideBackendlessAuthApi(
        okHttpClient: OkHttpClient,
        gsonBuilder: Gson,
    ): BackendlessAuthApi {

        return Retrofit.Builder()
            .baseUrl(""/*BACKENDLESS_BASE_URL.PIXELS_BASE_URL*/)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .build()
            .create(BackendlessAuthApi::class.java)

    }

}