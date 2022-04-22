
plugins {
    kotlin("jvm") version "1.6.20"
    `java-library`
    `maven-publish`
}

group = "me.kerelape.memoria"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(module("me.kerelape.memoria:memoria-core"))
    implementation(module("org.cactoos:cactoos:0.49"))

    testImplementation(kotlin("test"))
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/kerelape/memoria")
            credentials {
                username = System.getenv("GITHUB_USERNAME")
                password = System.getenv("GITHUB_PASSWORD")
            }
        }
    }
    publications {
        create<MavenPublication>("GitHubPackages") {
            groupId = project.group as String
            artifactId = rootProject.name
            version = project.version as String
        }
    }
}