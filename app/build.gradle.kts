plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    java
    alias(libs.plugins.dependency.version.checker)
}

group = "com.github.devcordde"
version = "0.0.1-SNAPSHOT"

java {
    toolchain{
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(libs.spring.boot.dependencies))
    implementation(libs.bundles.spring.boot.starter)
    implementation(libs.find.bugs)

    implementation(libs.bundles.webjars.locator)

    runtimeOnly(libs.bundles.webjars.dependencies) {
        exclude(group = "org.webjars.npm", module = "vue__compiler-sfc")
    }

    compileOnly(libs.spring.boot.configuration.processors)
    annotationProcessor(libs.spring.boot.configuration.processors)

    developmentOnly(libs.spring.boot.devtools)
    runtimeOnly(libs.bundles.databases)

    testImplementation(libs.bundles.spring.test)
}

tasks {
    test {
        useJUnitPlatform()
    }
}
