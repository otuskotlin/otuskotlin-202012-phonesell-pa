package com.example

import com.example.controllers.MpDemandController
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.util.pipeline.*
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.ResponseStatusDto
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandCreate
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandRead
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpResponseDemandCreate
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpResponseDemandRead

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val demandController= MpDemandController()
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

    install(ContentNegotiation) {
        json(
           contentType = ContentType.Application.Json,
           json = jsonConfig
        )

    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("static")
        }

        route("/demand"){
            post("/create") {
                demandController.create(this)
            }
        }

        route("/demand"){
            post("/read") {
                demandController.read(this)
            }
        }

        route("/demand"){
            post("/update") {
                demandController.update(this)
            }
        }

        route("/demand"){
            post("/delete") {
                demandController.delete(this)
            }
        }

        route("/phones"){
            post("/list") {
                demandController.listPhones(this)
            }
        }
    }
}


