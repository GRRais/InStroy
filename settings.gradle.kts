rootProject.name = "InStroy"
include(":shared")
include(":android")
include(":desktop")


dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}