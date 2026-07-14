package com.example.core_database_impl.data

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

//Убрать internal?
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal expect class RoomDatabaseFactory {
    internal fun createBuilder(): RoomDatabase.Builder<AppDatabase>
}

// Общая функция для финальной сборки базы данных
internal fun createRoomDatabase(factory: RoomDatabaseFactory): AppDatabase {
    return factory.createBuilder()
        // BundledSQLiteDriver обязателен для KMP, он компилирует SQLite внутрь приложения
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}