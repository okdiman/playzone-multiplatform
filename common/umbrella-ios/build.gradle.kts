plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin {
    /**
     * cocoapods - аналог gradle для ios, позволяет управлять зависимостями и выполнять скрипты
     */
    cocoapods {
        /**
         * summary - определяет то, как будет называться наша библиотека
         */
        summary = "Playzone iOS SDK"
        homepage = "https://google.com"
        ios.deploymentTarget = "14.0"

        framework {
            /**
             * transitiveExport - сообщает о то мбудем ли подключать зависимости наших
             * зависимостей или нет
             */
            transitiveExport = false
            /**
             * определяет способ линковки проекта (false по умолчанию)
             */
            isStatic = false
            baseName = "SharedSDK"

            export(project(":common:core"))
            export(project(":common:core-utils"))
            export(project(":common:auth:api"))
            export(project(":common:auth:root"))
            export(project(":common:games:api"))
            export(project(":common:games:root"))
            export(project(":common:tournaments:api"))
            export(project(":common:tournaments:root"))
            export(project(":common:main:api"))
            export(project(":common:main:root"))
            export(project(":common:umbrella-core"))
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:api"))
                implementation(project(":common:auth:root"))
                implementation(project(":common:games:api"))
                implementation(project(":common:games:root"))
                implementation(project(":common:tournaments:api"))
                implementation(project(":common:tournaments:root"))
                implementation(project(":common:main:api"))
                implementation(project(":common:main:root"))
                implementation(project(":common:umbrella-core"))
            }
        }
        iosMain {
            dependencies {
                api(project(":common:core"))
                api(project(":common:core-utils"))
                api(project(":common:auth:api"))
                api(project(":common:auth:root"))
                api(project(":common:games:api"))
                api(project(":common:games:root"))
                api(project(":common:tournaments:api"))
                api(project(":common:tournaments:root"))
                api(project(":common:main:api"))
                api(project(":common:main:root"))
                api(project(":common:umbrella-core"))
            }
        }
    }
}