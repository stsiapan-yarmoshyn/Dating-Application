package com.example.core_database_impl.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class RoomDatabaseFactory: KoinComponent {
    private val context: Context by inject()
    internal actual fun createBuilder(): RoomDatabase.Builder<AppDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath("my_app_database.db")
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}