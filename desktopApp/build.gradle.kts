plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm) // Используем чистый Kotlin JVM
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrains.compose)
}

dependencies {
    // Подключаем ваши обновленные модули
    implementation(project(":core-remote-api"))
    implementation(project(":core-remote-impl"))

    // Подключаем Ktor-движок для Desktop
    implementation(libs.ktor.client.cio)

//    // Зависимости Compose для рабочего стола
    implementation(compose.desktop.currentOs)
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.material3)
}

compose.desktop {
    application {
        mainClass = "MainKt" // Имя файла с функцией main
        nativeDistributions {
            targetFormats(org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi)
            packageName = "MyDesktopApp"
        }
    }
}
