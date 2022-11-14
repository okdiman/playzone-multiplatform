plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:games:api"))
                implementation(project(":common:core"))
            }
        }
    }
}

sqldelight {
    database("Database") {
        packageName = "com.okunev_dmitrii.playzone_mobile.games"
        dependency(project(":common:core"))
    }
}