import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose)
}

kotlin {
    // 1. Настраиваем платформы: Android и Desktop (JVM)
    androidTarget() {
        compilerOptions { jvmTarget.set(JvmTarget.JVM_11) }
    }
    jvm("desktop") {
        compilerOptions { jvmTarget.set(JvmTarget.JVM_11) }
    }

    // 2. Объединяем модули проекта
    sourceSets {
        commonMain.dependencies {
            // Ваши фичи и core-модули (написанные на KMP)
            implementation(project(":core-remote-api"))
            implementation(project(":core-database-api"))
            implementation(project(":feature-registration-api"))
            implementation(project(":core-remote-impl"))
            implementation(project(":core-database-impl"))
            implementation(project(":feature-registration-impl"))

            implementation(libs.koin.core)
            implementation(libs.navigation3.ui)
            implementation(libs.koin.compose.navigation3)
            implementation(libs.koin.compose) // Для koinInject() в UI
            implementation(libs.androidx.lifecycle.viewmodel.navigation3)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
        }

        androidMain.dependencies {
            implementation(libs.koin.android)
        }

        named("desktopMain") {
            dependencies {
                // Desktop-специфичный код shared-модуля
            }
        }
    }
}

android {
    namespace = "com.example.shared"
    compileSdk = 36
    defaultConfig { minSdk = 24 }
}