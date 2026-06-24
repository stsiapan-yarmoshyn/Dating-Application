package com.example.core_remote_impl.di

import com.example.core_remote_impl.data.model.register.AuthResult
import com.example.core_remote_impl.data.network.UserServiceApi
import com.example.core_remote_impl.data.util.register.RegisterResponseDeserializer
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
            .registerTypeAdapter(AuthResult::class.java, RegisterResponseDeserializer())
            .create()
    }

    @Singleton
    @Provides
    fun provideBackendlessAuthApi(
        okHttpClient: OkHttpClient,
        gsonBuilder: Gson,
    ): UserServiceApi {

        return Retrofit.Builder()
            .baseUrl(""/*BACKENDLESS_BASE_URL.BACKENDLESS_BASE_URL*/)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .build()
            .create(UserServiceApi::class.java)

    }

}