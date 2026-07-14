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

rootProject.name = "DatingApplication"

include(":app")
include(":desktopApp")

include(":feature-registration-impl")
include(":feature-registration-api")
include(":feature-login-api")
include(":feature-login-impl")
include(":feature-matching-api")
include(":feature-matching-impl")
include(":feature-chat-api")
include(":feature-chat-impl")
include(":core-remote-api")
include(":core-remote-impl")
include(":core-notification-api")
include(":core-notification-impl")
include(":core-database-impl")
include(":core-database-api")
