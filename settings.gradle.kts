
rootProject.name = "otuskotlin-phonesell-pa"


pluginManagement {
    plugins {
        val kotlinVersion: String by settings

        kotlin("jvm") version kotlinVersion apply false
        kotlin("js") version kotlinVersion apply false
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
    }
}

include("ok-phonesell-pa-common-mp")
include("ok-phonesell-pa-common-be")
include("ok-phonesell-pa-transport-mp")
include("ok-phonesell-pa-transport-mappers")