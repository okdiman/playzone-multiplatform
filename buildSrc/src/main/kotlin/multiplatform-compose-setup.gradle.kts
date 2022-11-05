import gradle.kotlin.dsl.accessors._564d40bd18529803cf74475d5dee0403.compose
import gradle.kotlin.dsl.accessors._564d40bd18529803cf74475d5dee0403.kotlin
import gradle.kotlin.dsl.accessors._564d40bd18529803cf74475d5dee0403.sourceSets
import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm("desktop")
    android()

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
            }
        }

        named("desktopMain") {
            dependencies {
                implementation(compose.desktop.common)
            }
        }
    }
}