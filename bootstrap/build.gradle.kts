plugins {
    alias(libs.plugins.spring.boot) apply true
}

dependencies {
    implementation(project(":web"))
    implementation(project(":application"))
    implementation(project(":persistence"))

    implementation(platform(libs.bom.spring.boot))
    implementation(libs.spring.boot.starter)
}
