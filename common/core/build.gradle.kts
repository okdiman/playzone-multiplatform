import dependenciesGroups.commonKotlin
import dependenciesGroups.commonKtor
import dependenciesGroups.settings

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
                commonKotlin()
                commonKtor()
                settings()
                api(Dependencies.Kodein.core)
                api(Dependencies.SqlDelight.core)
            }
        }
        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android)
                implementation(Dependencies.SqlDelight.android)
            }
        }
        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios)
                implementation(Dependencies.SqlDelight.ios)
            }
        }
        desktopMain {
            dependencies {
                implementation(Dependencies.Ktor.okhttp)
                implementation(Dependencies.SqlDelight.desktop)
            }
        }
    }
}

sqldelight {
    database("Database") {
        packageName = "com.okunev_dmitrii.playzone_mobile"
        schemaOutputDirectory = file("src/commonMain/sqldelight/database/schema")
        migrationOutputDirectory = file("src/commonMain/sqldelight/database/migrations")
    }
}