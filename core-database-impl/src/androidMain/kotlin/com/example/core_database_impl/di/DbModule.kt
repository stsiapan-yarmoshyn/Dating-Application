package com.example.core_database_impl.di

import android.content.Context
import com.example.core_database_impl.data.AppDatabase
import com.example.core_database_impl.data.RoomDatabaseFactory
import com.example.core_database_impl.data.createRoomDatabase
import com.example.core_database_impl.data.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object DbModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        val factory = RoomDatabaseFactory(context)
        return createRoomDatabase(factory)
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.getUserDao() // Ваши DAO теперь тоже берутся отсюда
    }
}
