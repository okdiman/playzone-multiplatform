import gradle.kotlin.dsl.accessors._ae3bc18e8f87dd53ae9f05e8d39a6af4.android

plugins {
    id("com.android.library")
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = 33

    defaultConfig {
        targetSdk = 33
        minSdk = 23
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
}