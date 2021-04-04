plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    val kotestVersion: String by project

    implementation(kotlin("stdlib"))
    implementation(project(":ok-phonesell-pa-common-be"))
    implementation(project(":ok-phonesell-pa-mp-pipelines"))
    implementation(project(":ok-phonesell-pa-mp-pipelines-validation"))
    implementation(project(":ok-phonesell-pa-common-mp"))
    testCompile("junit", "junit", "4.12")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))

    testImplementation(kotlin("test-junit5"))
    testImplementation(platform("org.junit:junit-bom:5.7.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}
