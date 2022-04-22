
plugins {
    kotlin("jvm") version "1.6.20"
    `maven-publish`
    `java-library`
}

group = "me.kerelape.memoria"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
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