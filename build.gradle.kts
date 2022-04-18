
tasks.register("test") {
    dependsOn(
        gradle.includedBuild("core").task(":test"),
        gradle.includedBuild("cactoos").task(":test")
    )
}
