plugins {
    kotlin("jvm") version "1.6.0"
    application
}

group = "aoc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("MainKt")
}

dependencies {
    implementation(kotlin("stdlib"))
}