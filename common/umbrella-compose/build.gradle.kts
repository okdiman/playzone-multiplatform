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
                implementation(project(":common:core"))
                implementation(project(":common:core-compose"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:root"))
                implementation(project(":common:auth:compose"))
                implementation(project(":common:games:root"))
                implementation(project(":common:tournaments:root"))
                odyssey()
                kViewModel()
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.composeActivity)
            }
        }
    }
}