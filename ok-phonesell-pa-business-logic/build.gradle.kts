plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":ok-phonesell-pa-common-be"))
   // implementation(project(":ok-phonesell-pa-mp-pipelines"))
    testCompile("junit", "junit", "4.12")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}
