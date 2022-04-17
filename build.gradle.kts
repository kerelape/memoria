
tasks.register("test") {
    dependsOn(gradle.includedBuild("core").task(":test"))
}
s