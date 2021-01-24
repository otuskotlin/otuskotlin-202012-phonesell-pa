plugins {
    java
    kotlin("jvm") version "1.4.10"
}

group = "ru.otus.otuskotlin.phonesell-pa"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}
