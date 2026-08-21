package com.example.core_database_impl.data.session

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath
import org.koin.core.module.Module

// Имя файла настроек сессии
const val DATASTORE_FILE_NAME = "session_prefs.preferences_pb"

// Функция, которая создает сам DataStore на основе переданного пути к файлу
fun createDataStore(producePath: () -> String): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = { producePath().toPath() }
    )
}

// Ожидаем платформенные модули Koin
expect val platformDataStoreModule: Module