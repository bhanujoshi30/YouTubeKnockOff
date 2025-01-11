pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "VideoApp"
include(":app")
include(":features:home")
include(":features:trending")
include(":features:profile")
include(":mylibrary")
include(":Core")
include(":features:core")
include(":features:commonui")
