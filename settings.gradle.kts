rootProject.name = "otuskotlin-202012-phonesell-pa"
pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        val openapiVersion: String by settings
        val springVersion: String by settings
        val springDependencyVersion: String by settings
        val bmuschkoVersion: String by settings
        val kotlessVersion: String by settings

        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("jvm") version kotlinVersion apply false
        kotlin("js") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
        id("org.openapi.generator") version "4.3.1" apply false
        id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion apply false
        id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion apply false
        id("org.springframework.boot") version springVersion apply false
        id("io.spring.dependency-management") version springDependencyVersion apply false
        id("com.bmuschko.docker-java-application") version bmuschkoVersion apply false
        id("io.kotless") version kotlessVersion apply false
    }

    repositories {
        maven { url = uri("https://repo.spring.io/snapshot") }
        maven { url = uri("https://repo.spring.io/milestone") }
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }
}

include("ok-202012-phonesell-pa-helloworld")
include("ok-phonesell-pa-common-mp")
include("ok-phonesell-pa-common-mp")
include("ok-phonesell-pa-common-be")
