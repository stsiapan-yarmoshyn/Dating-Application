import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.ksp)
    kotlin("multiplatform")
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
                implementation(project(":feature-matching-api"))
                implementation(project(":core-database-api"))
                implementation(project(":core-remote-api"))
                implementation(project(":core-notification-api"))

                //Glide
                implementation(libs.coil.compose)
                implementation(libs.coil.network.ktor)

                implementation(libs.kmpalette.core)

                // Compose Multiplatform UI компоненты
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                // Официальная Jetpack ViewModel KMP
                implementation(libs.androidx.lifecycle.viewmodel.compose)
                implementation(libs.koin.compose)
                implementation(libs.koin.core)
                implementation(libs.koin.core.viewmodel)
                implementation(libs.koin.compose.viewmodel)
                implementation(libs.navigation3.ui)
            }
        }
        val androidMain by getting {
            dependencies {
            }
        }
    }
}

configure<com.android.build.api.dsl.LibraryExtension> {
    namespace = "com.example.feature_matching_impl"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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