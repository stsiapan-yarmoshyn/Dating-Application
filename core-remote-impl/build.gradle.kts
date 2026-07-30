import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.android.library)
    alias(libs.plugins.buildKonfig)
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use { stream ->
        localProperties.load(stream)
    }
}

kotlin {
    // Настрока android и desktop платформ
    androidTarget() {
        compilerOptions { jvmTarget.set(JvmTarget.JVM_11) }
    }
    jvm("desktop") {
        compilerOptions { jvmTarget.set(JvmTarget.JVM_11) }
    }
    // Разносим зависимости по платформам
    sourceSets {
        // Общий код для Android и Desktop (Здесь Ktor)
        val commonMain by getting {
            dependencies {
                implementation(project(":core-remote-api"))
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.ktor.client.logging)
                implementation(libs.koin.core)
                implementation(libs.ktor.client.cio)
            }
        }

        // Чисто Android-зависимости (Сюда уезжает Hilt и Retrofit)
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.core.ktx)
                implementation(libs.androidx.appcompat)
                implementation(libs.material)

                // Пока мы не переписали весь код на Ktor, Retrofit временно поживет тут
                implementation(libs.retrofit)
                implementation(libs.converter.gson)
                implementation(libs.logging.interceptor)
                implementation(libs.okhttp)
                implementation(libs.ktor.client.okhttp) // Движок Ktor для Android
            }
        }

        // Чисто Desktop-зависимости
        val desktopMain by getting {
            dependencies {
                implementation(libs.ktor.client.cio) // Движок Ktor для Desktop
            }
        }
    }
}

//replace by extensions.configure<com.android.build.api.dsl.LibraryExtension>  ???
extensions.configure<com.android.build.api.dsl.LibraryExtension> {
    namespace = "com.example.core_remote_impl"


    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

buildkonfig {
    packageName = "com.example.core_remote_impl"

    // Если у вас в gradle.properties настроен флавор (например, buildkonfig.flavor=dev)
    defaultConfigs {
        // STRING берется напрямую из импорта вверху страницы
            buildConfigField(
                com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING,
                "BACKENDLESS_APP_KEY",
                "\"${localProperties.getProperty("BACKENDLESS_APP_KEY")}\""
            )
            buildConfigField(
                com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING,
                "BACKENDLESS_BASE_URL",
                "\"${localProperties.getProperty("BACKENDLESS_BASE_URL")}\""
            )
    }
}

dependencies {

    implementation(project(":core-remote-api"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.okhttp)
}