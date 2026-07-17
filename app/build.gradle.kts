plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.example.datingapplication"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.datingapplication"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

subprojects {
    configurations.configureEach {
        resolutionStrategy {
            force("androidx.activity:activity:1.9.0")
            force("androidx.activity:activity-ktx:1.9.0")
        }
    }
}

dependencies {
    implementation(project(":feature-registration-api"))
    implementation(project(":feature-login-api"))
    implementation(project(":feature-matching-api"))
    implementation(project(":feature-chat-api"))
    implementation(project(":core-remote-api"))
    implementation(project(":core-database-api"))
    implementation(project(":core-notification-api"))

    implementation(project(":core-navigation-api"))

    implementation(project(":feature-registration-impl"))
    implementation(project(":core-remote-impl"))
    implementation(project(":core-database-impl"))
//    implementation(project(":feature-login-impl"))
//    implementation(project(":feature-matching-impl"))
//    implementation(project(":feature-chat-impl"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    implementation("androidx.navigation:navigation-compose:2.8.0")
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}