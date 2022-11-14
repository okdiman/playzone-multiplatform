import dependenciesGroups.odyssey

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {
        withJava()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-compose"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:compose"))
                implementation(project(":common:umbrella-core"))
                implementation(project(":common:umbrella-compose"))

                odyssey()
            }
        }

        named("jvmMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

/**
 * настройка Gradle для compose desktop
 */
compose.desktop {
    application {
        /**
         * главный класс
         */
        mainClass = "Main_desktopKt"

        nativeDistributions {
            /**
             * указываем таргеты
             */
            targetFormats(
                /**
                 * Dmg - MacOS, Msi- Windows, Deb - Linux
                 */
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
            )
            packageName = "Playzone-Admin"
            packageVersion = "1.0.0"

            /**
             * настройка для винды
             */
            windows {
                menuGroup = "PlayZone Admin"
                // see https://wixtoolset.org/documentation/manual/v3/howtos/general/generate_guids.html
                upgradeUuid = "18159995-d967-4CD2-8885-77BFA97CFA9F"
            }
        }
    }
}