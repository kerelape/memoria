
plugins {
    kotlin("jvm") version "1.6.20"
}

repositories {
    mavenCentral()
}

dependencies {
    api(module("me.kerelape.memoria:memoria-core"))
    api(module("org.cactoos:cactoos:0.49"))
}