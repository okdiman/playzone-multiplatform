plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:root"))
                implementation(project(":common:games:root"))
                implementation(project(":common:tournaments:root"))

                implementation(Dependencies.Kodein.core)
            }
        }
    }
}