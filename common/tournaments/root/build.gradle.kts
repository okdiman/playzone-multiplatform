plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:tournaments:api"))
                implementation(project(":common:core"))
            }
        }
    }
}