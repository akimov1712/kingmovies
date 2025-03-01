pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "kingmovies"
include(":app")
include(":core")
include(":core:ui")
include(":core:common")
include(":core:android")
include(":feature")
include(":feature:splash")
include(":feature:privacy")
include(":domain")
include(":data")
include(":feature:agreement")
include(":feature:auth")
include(":navigation")
include(":feature:main")
include(":feature:search")
include(":feature:film")
include(":feature:catalog")
include(":feature:catalog:filter")
