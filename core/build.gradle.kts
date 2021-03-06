
plugins {
    kotlin("jvm") version "1.6.20"
    `maven-publish`
    `java-library`
}

group = "me.kerelape"

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
                username = System.getenv("PUBLISH_GITHUB_USERNAME")
                password = System.getenv("PUBLISH_GITHUB_PASSWORD")
            }
        }
    }
    publications {
        create<MavenPublication>("GitHubPackages") {
            groupId = project.group as String
            artifactId = rootProject.name
            version = System.getenv("PUBLISH_PACKAGE_VERSION")
        }
    }
}
