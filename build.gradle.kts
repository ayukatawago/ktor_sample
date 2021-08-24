plugins {
    kotlin("jvm") version "1.5.21"
    id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
