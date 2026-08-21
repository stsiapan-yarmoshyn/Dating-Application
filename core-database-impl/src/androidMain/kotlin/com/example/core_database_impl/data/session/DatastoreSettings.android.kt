package com.example.core_database_impl.data.session

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.io.File

actual val platformDataStoreModule = module {
    single {
        createDataStore(
            producePath = {
                File(androidContext().filesDir, "datastore/$DATASTORE_FILE_NAME").absolutePath
            }
        )
    }
}