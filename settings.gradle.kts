
rootProject.name = "otuskotlin-phonesell-pa"


pluginManagement {
    val kotlinVersion: String by settings
    val openapiVersion: String by settings
    val springDependencyVersion: String by settings
    val springBootVersion: String by settings
    val bmuschkoVersion: String by settings
    val kotlessVersion: String by settings

    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion
        kotlin("js") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion

        //id("org.openapi.generator") version openapiVersion
        //id("org.springframework.boot") version springBootVersion
        //id("io.spring.dependency-management") version springDependencyVersion
        id("com.bmuschko.docker-java-application") version bmuschkoVersion
        //id("io.kotless") version kotlessVersion apply false
    }
}

include("ok-phonesell-pa-common-mp")
include("ok-phonesell-pa-common-be")
include("ok-phonesell-pa-transport-mp")
include("ok-phonesell-pa-transport-mappers")
include("ok-phonesell-pa-app-ktor")
include ("ok-phonesell-pa-business-logic")
include ("ok-phonesell-pa-mp-pipelines")
include("ok-phonesell-pa-mp-pipelines-validation")
