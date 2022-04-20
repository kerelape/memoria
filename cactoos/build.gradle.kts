
plugins {
    kotlin("jvm") version "1.6.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(module("me.kerelape.memoria:memoria-core"))
    implementation(module("org.cactoos:cactoos:0.49"))

    testImplementation(kotlin("test"))
}