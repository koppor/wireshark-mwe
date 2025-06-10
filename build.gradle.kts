plugins {
    application
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // wiremock patch
    testImplementation("org.wiremock:wiremock:3.13.0")
    implementation("com.github.koppor:wiremock-slf4j-shim:main-SNAPSHOT")
    testImplementation("com.github.koppor:wiremock-slf4j-spi-shim:main-SNAPSHOT")
    implementation("com.github.jknack:handlebars:4.3.1") {
        exclude(group = "org.mozilla", module = "rhino")
    }
    implementation("com.github.jknack:handlebars-helpers:4.3.1") {
        exclude(group = "org.mozilla", module = "rhino")
        exclude(group = "org.apache.commons", module = "commons-lang3")
    }
}


java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "org.example.App"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
