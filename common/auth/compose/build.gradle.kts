import dependenciesGroups.androidCompose

plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:root"))
                implementation(Dependencies.Other.ViewModel.core)
            }
        }

        androidMain {
            dependencies {
                androidCompose()
            }
        }
    }
}