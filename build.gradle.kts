plugins {
    alias(libs.plugins.kotlin.jvm) apply true
}

allprojects {
    group = "eu.luftiger.cae"
    version = "1.0"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = rootProject.libs.plugins.kotlin.jvm.get().pluginId)

    dependencies {
        implementation(rootProject.libs.bundles.kotlin)
    }
}