package dependenciesGroups

import Dependencies
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.commonKtor() {
    api(Dependencies.Ktor.core)
    implementation(Dependencies.Ktor.json)
    implementation(Dependencies.Ktor.serialization)
    implementation(Dependencies.Ktor.negotiation)
    implementation(Dependencies.Ktor.kotlin_json)
    implementation(Dependencies.Ktor.logging)
}

fun KotlinDependencyHandler.commonKotlin() {
    api(Dependencies.Kotlin.Serialization.serialization)
    api(Dependencies.Kotlin.Coroutines.core)
}

fun KotlinDependencyHandler.androidCompose() {
    implementation(Dependencies.Android.Compose.ui)
    implementation(Dependencies.Android.Compose.material)
    implementation(Dependencies.Android.Compose.tooling)
    implementation(Dependencies.Android.Compose.icons)
}

fun KotlinDependencyHandler.odyssey() {
    api(Dependencies.Other.Navigation.compose)
    api(Dependencies.Other.Navigation.core)
}

fun KotlinDependencyHandler.kViewModel(){
    implementation(Dependencies.Other.ViewModel.core)
    implementation(Dependencies.Other.ViewModel.compose)
    implementation(Dependencies.Other.ViewModel.odyssey)
}

fun KotlinDependencyHandler.settings(){
    implementation(Dependencies.Settings.core)
    implementation(Dependencies.Settings.noargs)
}