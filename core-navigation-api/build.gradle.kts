plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
    }
}

dependencies {
    // Взамен core-ktx добавляем библиотеку корутин для работы с SharedFlow
    // Замените на вашу переменную из libs.versions.toml, если она там есть
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
}