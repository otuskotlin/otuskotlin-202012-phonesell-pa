package com.example.controllers

import com.example.helpers.WsUserSession
import com.example.helpers.service
import com.example.jsonConfig
import com.example.services.DemandService
import com.example.toModel
import io.ktor.application.*
import io.ktor.http.cio.websocket.*
import io.ktor.routing.*
import io.ktor.websocket.*
import kotlinx.coroutines.channels.ClosedReceiveChannelException
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.common.be.repositories.EmptyUserSession
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import java.time.Instant
import java.util.*

private val sessions = mutableMapOf<WebSocketSession, WsUserSession>()
/*
fun Application.websocketEndpoints(
    demandService: DemandService,
) {
    install(WebSockets)

    routing {
        mpWebsocket(demandService)
    }
}
*/
@OptIn(InternalSerializationApi::class)
fun Routing.mpWebsocket(
    demandService: DemandService,
) {
    webSocket("/ws") { // websocketSession
        sessions[this] = WsUserSession(fwSession = this)
        apply {
            val ctx = MpBeContext(
                responseId = UUID.randomUUID().toString(),
                timeStarted = Instant.now(),
                userSession = sessions[this] ?: EmptyUserSession,
                status = MpBeContextStatus.RUNNING
            )
            service(
                context = ctx,
                query = null,
                demandService = demandService,
            )?.also {
                val respJson = jsonConfig.encodeToString(MpMessage::class.serializer(), it)
                outgoing.send(Frame.Text(respJson))
            }
        }

        for (frame in incoming) {
            if (frame is Frame.Text) {
                val ctx = MpBeContext(
                    responseId = UUID.randomUUID().toString(),
                    timeStarted = Instant.now(),
                    userSession = sessions[this] ?: EmptyUserSession
                )
                try {
                    val requestJson = frame.readText()
                    val query = jsonConfig.decodeFromString(MpMessage.serializer(), requestJson)
                    ctx.status = MpBeContextStatus.RUNNING
                    service(
                        context = ctx,
                        query = query,
                        demandService = demandService,
                    )?.also {
                        val respJson = jsonConfig.encodeToString(MpMessage::class.serializer(), it)
                        outgoing.send(Frame.Text(respJson))
                    }
                } catch (e: ClosedReceiveChannelException) {
                    service(
                        context = ctx,
                        query = null,
                        demandService = demandService,
                    )
                    sessions -= this
                } catch (e: Throwable) {
                    e.printStackTrace()
                    ctx.status = MpBeContextStatus.FAILING
                    ctx.errors.add(e.toModel())
                    service(
                        context = ctx,
                        query = null,
                        demandService = demandService,
                    )?.also {
                        val respJson = jsonConfig.encodeToString(MpMessage::class.serializer(), it)
                        outgoing.send(Frame.Text(respJson))
                    }
                }

                val responseJson = ""
//                    if (text.equals("bye", ignoreCase = true)) {
//                        close(CloseReason(CloseReason.Codes.NORMAL, "Client said BYE"))
//                    }
            }
        }
    }
}
