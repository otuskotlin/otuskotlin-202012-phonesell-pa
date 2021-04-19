package com.example

import io.ktor.http.cio.websocket.*
import io.ktor.server.testing.*
import kotlinx.coroutines.withTimeoutOrNull
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.ResponseStatusDto
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandRead
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpResponseDemandRead
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

internal class WebsocketTest {
    @Test
    fun demandReadTest() {
        withTestApplication({ module(testing = true) }) {
            handleWebSocketConversation("/ws") { incoming, outgoing ->
                val query = MpRequestDemandRead(
                    requestId = "123",
                    /*debug = MpRequestDemandRead.Debug(
                        stubCase = MpRequestDemandRead.StubCase.SUCCESS
                    ),*/
                    stubCase=MpRequestDemandRead.StubCase.SUCCESS,

                )

                withTimeoutOrNull(250L) {
                    while (true) {
                        val respJson =(incoming.receive() as Frame.Text).readText()
                        println("GOT INIT RESPONSE: $respJson")
                    }
                }




                val requestJson = jsonConfig.encodeToString(MpMessage.serializer(), query)
                println("REQUEST: $requestJson")
                outgoing.send(Frame.Text(requestJson))
                val respJson =(incoming.receive() as Frame.Text).readText()
                println("respJson: $respJson")
                val response = jsonConfig.decodeFromString(MpMessage.serializer(),respJson) as MpResponseDemandRead
                println("RESPONSE: $response")
                assertEquals("Petrov", response.demand?.lastName)

            }
        }
    }

}
