import gradle.kotlin.dsl.accessors._1ec61fb12a95598c5153314aa798c337.kotlin
import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("kapt")
}

kotlin {
    jvm("desktop")
    android()
    ios()
}