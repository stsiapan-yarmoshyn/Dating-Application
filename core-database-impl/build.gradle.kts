import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
}

kotlin {
    androidTarget() {
        compilerOptions { jvmTarget.set(JvmTarget.JVM_11) }
    }
    jvm("desktop") {
        compilerOptions { jvmTarget.set(JvmTarget.JVM_11) }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":core-database-api"))

                // Общий рантайм Room KMP
                implementation(libs.androidx.room.runtime)
                // Обязательный KMP SQLite драйвер для Room (bundled)
                implementation(libs.androidx.sqlite.bundled)
                implementation(libs.koin.core)
            }
        }

        // Чисто Android-зависимости (Сюда уходят Hilt, UI-библиотеки и Paging)
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.core.ktx)
                implementation(libs.androidx.appcompat)
                implementation(libs.material)

                // Room-компоненты, специфичные для Android
                implementation(libs.androidx.room.ktx)
                implementation(libs.androidx.room.paging)

            }
        }

        // Чисто Desktop-зависимости (если понадобятся специфичные либы)
        val desktopMain by getting {
            dependencies {
                // Драйвер SQLite для десктопа подтянется из commonMain автоматически
            }
        }
    }
}

android {
    namespace = "com.example.core_database_impl"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Компилятор Room для общего кода (генерирует Dao и базы данных под KMP)
    add("kspCommonMainMetadata", libs.androidx.room.compiler)
}
