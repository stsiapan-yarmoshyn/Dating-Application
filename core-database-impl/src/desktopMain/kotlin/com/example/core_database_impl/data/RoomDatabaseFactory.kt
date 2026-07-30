package com.example.core_database_impl.data

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class RoomDatabaseFactory {
    internal actual fun createBuilder(): RoomDatabase.Builder<AppDatabase> {
        // Находим домашнюю папку пользователя (C:\Users\Name на Windows или /Users/Name на Mac)
        val userHome = System.getProperty("user.home")
        val appDir = File(userHome, ".my_app_desktop")

        if (!appDir.exists()) {
            appDir.mkdirs() // Создаем папку, если её нет
        }

        val dbFile = File(appDir, "my_app_database.db")
        return Room.databaseBuilder<AppDatabase>(
            name = dbFile.absolutePath
        )
    }
}