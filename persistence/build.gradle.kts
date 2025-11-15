plugins {
    alias(libs.plugins.spring.boot) apply true
}

dependencies {
    implementation(project(":application"))
    //implementation(platform(libs.bom.spring.boot))
    //implementation(libs.spring.boot.jpa)
}