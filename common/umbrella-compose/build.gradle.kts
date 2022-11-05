plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:auth:root"))
                implementation(project(":common:games:root"))
                implementation(project(":common:tournaments:root"))
            }
        }
    }
}