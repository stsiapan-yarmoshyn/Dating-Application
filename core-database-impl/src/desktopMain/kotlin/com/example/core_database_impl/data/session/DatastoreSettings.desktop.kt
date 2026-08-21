package com.example.core_database_impl.data.session

import org.koin.dsl.module
import java.io.File

actual val platformDataStoreModule = module {
    single {
        createDataStore(
            producePath = {
                // Имя папки вашего приложения (замените на свое)
                val appName = "YourAppName"

                // Путь к домашней директории пользователя (например, C:\Users\Username или /home/user)
                val userHome = System.getProperty("user.home")

                // Создаем скрытую папку .your_app_name внутри домашней директории
                val appDataDir = File(userHome, ".$appName")
                if (!appDataDir.exists()) {
                    appDataDir.mkdirs()
                }

                File(appDataDir, DATASTORE_FILE_NAME).absolutePath
            }
        )
    }
}