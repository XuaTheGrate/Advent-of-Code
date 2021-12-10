plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "aoc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

application {
    mainClass.set("aoc.MainKt")
}

tasks.withType<Jar> {
    manifest {
        attributes(
            "Implementation-Title" to "Advent of Code",
            "Implementation-Version" to "1.0.0",
            "Main-Class" to "aoc.MainKt"
        )
    }
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}
