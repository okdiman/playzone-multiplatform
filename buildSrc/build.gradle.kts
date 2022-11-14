plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    mavenLocal()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(Dependencies.Android.gradlePlugin)
    implementation(Dependencies.Kotlin.gradlePlugin)
    implementation(Dependencies.Compose.gradlePlugin)
    implementation(Dependencies.Kotlin.Serialization.gradlePlugin)
    implementation(Dependencies.SqlDelight.gradlePlugin)
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}