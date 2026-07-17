import org.gradle.kotlin.dsl.implementation
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.jetbrains.compose)
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
                implementation(project(":feature-registration-api"))
                implementation(project(":core-remote-api"))
                implementation(project(":core-database-api"))
                implementation(project(":core-navigation-api"))

                // Compose Multiplatform UI компоненты
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                // Официальная Jetpack ViewModel KMP
                implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.hilt.android)
                implementation(libs.material)
                implementation(libs.androidx.hilt.navigation.compose)
//                implementation(project(":core-navigation"))
            }
        }
    }
}


android {
    namespace = "com.example.feature_registration_impl"
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

dependencies {

    ksp(libs.hilt.android.compiler)
}