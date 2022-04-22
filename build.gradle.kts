
tasks.register("test") {
    dependsOn(
        gradle.includedBuild("core").task(":test"),
        gradle.includedBuild("cactoos").task(":test")
    )
}

tasks.register("publish") {
    dependsOn(
        gradle.includedBuild("core").task(":publish"),
        gradle.includedBuild("cactoos").task(":publish")
    )
}