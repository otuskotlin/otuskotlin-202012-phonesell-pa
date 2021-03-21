package com.example
import io.ktor.http.*
import io.ktor.server.testing.*
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.ResponseStatusDto
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.*
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.MpRequestOffersList
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.MpResponseOffersList
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("HELLO WORLD!", response.content)
            }
        }
    }
    @Test
    fun testCreate() {
        withTestApplication({ module(testing = true)}) {
            handleRequest(HttpMethod.Post, "/demand/create") {
                val body = MpRequestDemandCreate(
                    requestId = "NewReq1",
                    createData = MpDemandCreateDto(
                        firstName = "Petrov",
                        lastName = "Alexandr",
                        contactPhone = "+79213245777",
                        email ="a.sav210@gmail.com",
                        products = mutableSetOf(
                            DemandProductsDto(
                                id="1234",
                                idProduct="Offer1",
                                quantity="1"
                            ),
                            DemandProductsDto(
                                id="1235",
                                idProduct="Offer2",
                                quantity="2"
                            ),

                        ),


                    )
                )
                val bodyString = jsonConfig.encodeToString(MpMessage.serializer(), body)
                setBody(bodyString)
                println(bodyString)
                addHeader("Content-Type", "application/json")

            }.apply {
                //println (response.content)

                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
                val jsonString = response.content?: fail("Null response json")
                println(jsonString)

                val res = (jsonConfig.decodeFromString(MpMessage.serializer(), jsonString) as? MpResponseDemandCreate)
                    ?: fail("Incorrect response format")
                assertEquals(ResponseStatusDto.SUCCESS, res.status)
                assertEquals("NewResp1", res.responseId)
                assertEquals("NewReq1", res.onRequest)
                //assertEquals("test-demand", res.demand?.title)
            }
        }
    }
    @Test
    fun testRead() {
        withTestApplication({ module(testing = true)}) {
            handleRequest(HttpMethod.Post, "/demand/read") {
                val body = MpRequestDemandRead(
                    requestId = "321",
                    demandId = "123",
                )
                val bodyString = jsonConfig.encodeToString(MpMessage.serializer(), body)
                setBody(bodyString)
                println(bodyString)
                addHeader("Content-Type", "application/json")

            }.apply {
                //println (response.content)

                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
                val jsonString = response.content?: fail("Null response json")
                println(jsonString)

                val res = (jsonConfig.decodeFromString(MpMessage.serializer(), jsonString) as? MpResponseDemandRead)
                    ?: fail("Incorrect response format")


                assertEquals(ResponseStatusDto.SUCCESS, res.status)
                assertEquals("123", res.responseId)
                assertEquals("321", res.onRequest)
                //assertEquals("test-demand", res.demand?.title)
            }
        }
    }
    @Test
    fun testUpdate() {
        withTestApplication({ module(testing = true)}) {
            handleRequest(HttpMethod.Post, "/demand/update") {
                val body = MpRequestDemandUpdate(
                    requestId = "UpdReq1",
                    updateData = MpDemandUpdateDto(
                        id="999",
                        firstName = "Petrov",
                        lastName = "Alexandr",
                        contactPhone = "+79213245777",
                        email ="a.sav210@gmail.com",
                        products = mutableSetOf(
                            DemandProductsDto(
                                id="1234",
                                idProduct="Offer1",
                                quantity="1"
                            ),
                            DemandProductsDto(
                                id="1235",
                                idProduct="Offer2",
                                quantity="2"
                            ),

                            )

                    )
                )
                val bodyString = jsonConfig.encodeToString(MpMessage.serializer(), body)
                setBody(bodyString)
                println(bodyString)
                addHeader("Content-Type", "application/json")

            }.apply {
                //println (response.content)

                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
                val jsonString = response.content?: fail("Null response json")
                println(jsonString)

                val res = (jsonConfig.decodeFromString(MpMessage.serializer(), jsonString) as? MpResponseDemandUpdate)
                    ?: fail("Incorrect response format")
                assertEquals(ResponseStatusDto.SUCCESS, res.status)
                //assertEquals("NewResp1", res.responseId)
                assertEquals("UpdReq1", res.onRequest)
                //assertEquals("test-demand", res.demand?.title)
            }
        }
    }
    @Test
    fun testDelete() {
        withTestApplication({ module(testing = true)}) {
            handleRequest(HttpMethod.Post, "/demand/delete") {
                val body = MpRequestDemandDelete(
                    requestId = "321",
                    demandId = "123",
                )
                val bodyString = jsonConfig.encodeToString(MpMessage.serializer(), body)
                setBody(bodyString)
                println(bodyString)
                addHeader("Content-Type", "application/json")

            }.apply {
                //println (response.content)

                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
                val jsonString = response.content?: fail("Null response json")
                println(jsonString)

                val res = (jsonConfig.decodeFromString(MpMessage.serializer(), jsonString) as? MpResponseDemandDelete)
                    ?: fail("Incorrect response format")


                assertEquals(ResponseStatusDto.SUCCESS, res.status)
                assertEquals("123", res.responseId)
                assertEquals("321", res.onRequest)
                //assertEquals("test-demand", res.demand?.title)
            }
        }
    }
    @Test
    fun testPhonesList() {
        withTestApplication({ module(testing = true)}) {
            handleRequest(HttpMethod.Post, "/phones/list") {
                val body = MpRequestOffersList(
                    requestId = "ReqList1",

                )
                val bodyString = jsonConfig.encodeToString(MpMessage.serializer(), body)
                setBody(bodyString)
                println(bodyString)
                addHeader("Content-Type", "application/json")

            }.apply {
                //println (response.content)

                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
                val jsonString = response.content?: fail("Null response json")
                println(jsonString)

                val res = (jsonConfig.decodeFromString(MpMessage.serializer(), jsonString) as? MpResponseOffersList)
                    ?: fail("Incorrect response format")

                assertEquals(ResponseStatusDto.SUCCESS, res.status)
                assertEquals("RespList1", res.responseId)
                assertEquals("ReqList1", res.onRequest)
                res.offers?.let {
                    with(it.elementAt(0)){
                        assertEquals("Iphone 11",model)
                    }
                }
                res.offers?.let {
                    with(it.elementAt(0)){
                        assertEquals("Qualcomm Snapdragon 662, 2000 МГц",memProcGrp?.cpu)
                    }
                }
                //assertEquals("test-demand", res.demand?.title)
            }
        }
    }
}
