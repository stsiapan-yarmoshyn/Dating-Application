package com.example.datingapplication.application

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext
class AndroidApp: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@AndroidApp)
        }
    }
}