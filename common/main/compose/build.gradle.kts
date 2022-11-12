import dependenciesGroups.androidCompose
import dependenciesGroups.coil
import dependenciesGroups.kViewModel
import dependenciesGroups.odyssey

plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:main:root"))
                implementation(project(":common:core-compose"))
                implementation(project(":common:core-utils"))
                kViewModel()
                odyssey()
            }
        }

        androidMain {
            dependencies {
                androidCompose()
                coil()
            }
        }
    }
}