package com.example.core_database_impl.data.session

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.inject
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.inject
import java.io.File
import kotlin.getValue

actual val platformDataStoreModule = module {
    single {
        createDataStore(
            producePath = {
                File(androidContext().filesDir, "datastore/$DATASTORE_FILE_NAME").absolutePath
            }
        )
    }
}