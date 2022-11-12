pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "playzone-mobile"
include(":androidApp")
include(":common:auth:api")
include(":common:auth:compose")
include(":common:auth:root")
include(":common:tournaments:api")
include(":common:tournaments:root")
include(":common:games:api")
include(":common:games:root")
include(":common:core")
include(":common:core-compose")
include(":common:core-utils")
include(":common:umbrella-ios")
include(":common:umbrella-compose")
include(":common:umbrella-core")
include(":common:main:api")
include(":common:main:root")
include(":common:main:compose")