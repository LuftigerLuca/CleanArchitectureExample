rootProject.name = "CleanArchitectureExample"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("kotlin", "2.2.10")
            version("spring-boot", "3.5.6")

            plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("kotlin-noarg", "org.jetbrains.kotlin.plugin.noarg").versionRef("kotlin")
            plugin("spring-boot", "org.springframework.boot").versionRef("spring-boot")

            // bom
            library("bom-spring-boot", "org.springframework.boot", "spring-boot-dependencies").versionRef("spring-boot")

            // kotlin
            library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib-jdk8").withoutVersion()
            library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").withoutVersion()

            // spring boot
            library("spring-boot-starter", "org.springframework.boot", "spring-boot-starter").withoutVersion()
            library("spring-boot-web", "org.springframework.boot", "spring-boot-starter-web").withoutVersion()
            //library("spring-boot-jpa", "org.springframework.boot", "spring-boot-starter-data-jpa").withoutVersion()

            // jackson
            library("jackson-jsr310", "com.fasterxml.jackson.datatype", "jackson-datatype-jsr310").withoutVersion()
            library("jackson-kotlin", "com.fasterxml.jackson.module", "jackson-module-kotlin").withoutVersion()
            library("jackson-databind", "com.fasterxml.jackson.core", "jackson-databind").withoutVersion()
            library("jackson-core", "com.fasterxml.jackson.core", "jackson-core").withoutVersion()

            // #################
            // bundles
            // #################

            bundle("kotlin", listOf("kotlin-stdlib", "kotlin-reflect"))
        }
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

include(
    "bootstrap",
    "web",
    "persistence",
    "application",
    "domain"
)