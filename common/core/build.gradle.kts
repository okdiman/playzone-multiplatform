import dependenciesGroups.commonKotlin
import dependenciesGroups.commonKtor

plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                commonKotlin()
                commonKtor()
                api(Dependencies.Kodein.core)
//                api(Dependencies.SqlDelight.core)
            }
        }
        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android)
//                implementation(Dependencies.SqlDelight.android)
            }
        }
        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios)
//                implementation(Dependencies.SqlDelight.ios)
            }
        }
        desktopMain {
            dependencies {
                implementation(Dependencies.Ktor.okhttp)
//                implementation(Dependencies.SqlDelight.desktop)
            }
        }
    }
}