plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "okunev.projects.playzone_mobile.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "okunev.projects.playzone_mobile.android"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":common:core"))
    implementation(project(":common:auth:api"))
    implementation(project(":common:games:api"))
    implementation(project(":common:tournaments:api"))
    implementation(project(":common:umbrella-compose"))
    implementation(project(":common:umbrella-core"))
    implementation(Dependencies.Android.composeActivity)
}