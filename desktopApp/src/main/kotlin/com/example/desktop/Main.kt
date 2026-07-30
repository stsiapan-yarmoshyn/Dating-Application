package com.example.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.initKoin
import navigation.App

fun main() {

    initKoin()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "My KMP App" // Заголовок окна для Desktop
        ) {
            App()
        }
    }

}