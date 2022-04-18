rootProject.name = "memoria"

includeBuild("./core") {
    dependencySubstitution {
        substitute(module("me.kerelape.memoria:memoria-core")).using(project(":"))
    }
}

includeBuild("./cactoos")