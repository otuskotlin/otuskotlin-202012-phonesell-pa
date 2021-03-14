package com.example.controllers

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import org.slf4j.LoggerFactory
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.ResponseStatusDto
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.*
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.MpRequestOffersList
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.MpResponseOffersList
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.OfferProductParamsDto
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.OfferProductsDto
import java.time.Instant

class MpDemandController {
    private val log=LoggerFactory.getLogger(this::class.java)!!

    suspend fun create(pipelineContext: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request=pipelineContext.call.receive<MpMessage>() as MpRequestDemandCreate
            //some logic
            val response:MpMessage=MpResponseDemandCreate(
                responseId = "NewResp1",
                onRequest = request.requestId,
                endTime =Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                demand = request.createData
                /*demand = MpDemandDto(
                    lastName = "Petrov",
                    firstName = "Alexandr",
                    contactPhone = "+79213245777",
                    email = "a.sav210@gmail.com" ,
                    id ="Demand1"
                )*/

            )
            pipelineContext.call.respond(response)

        } catch (e: Throwable){
            log.error ("Read chain error",e)
            /*MpResponseDemandCreate(
                responseId = "NewResp1",
                status = ResponseStatusDto.INTERNAL_SERVER_ERROR,
            )*/

        }

    }
    suspend fun read(pipelineContext: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request=pipelineContext.call.receive<MpMessage>() as MpRequestDemandRead
            //some logic
            val response:MpMessage=MpResponseDemandRead(
                responseId = "123",
                onRequest = request.requestId,
                endTime=Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,

            )
            pipelineContext.call.respond(response)

        } catch (e: Throwable){
            log.error ("Read chain error",e)

        }

    }

    suspend fun list(pipelineContext: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request=pipelineContext.call.receive<MpMessage>() as MpRequestOffersList
            //some logic
            val response:MpMessage=MpResponseOffersList(
                responseId = "RespList1",
                onRequest = request.requestId,
                endTime =Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                offers =mutableSetOf(
                        OfferProductsDto(
                            id = "Offer1",
                            brand ="Apple",
                            model = "Iphone 11",
                            quantityStock = "4",
                            description ="Самый лучший телефон",
                            price = "100000",
                            params = mutableSetOf(
                                OfferProductParamsDto(
                                    id="Offer1Prop1",
                                    nameParam="Цвет",
                                    valueParam="Черный",
                                ),
                                OfferProductParamsDto(
                                    id="Offer1Prop1",
                                    nameParam="Диоганаль",
                                    valueParam="3.5 дюйма",
                                ),
                            )
                       ),OfferProductsDto(
                            id = "Offer2",
                            brand ="Samsung",
                            model = "Galaxy 5",
                            quantityStock = "20",
                            description ="Отличныйтелефон",
                            price = "50000",
                            params = mutableSetOf(
                                OfferProductParamsDto(
                                    id="Offer1Prop1",
                                    nameParam="Цвет",
                                    valueParam="Черный",
                                ),
                                OfferProductParamsDto(
                                    id="Offer1Prop1",
                                    nameParam="Диоганаль",
                                    valueParam="3.5 дюйма",
                                ),
                            )
                        ),
                )
            )
            pipelineContext.call.respond(response)

        } catch (e: Throwable){
            log.error ("Read chain error",e)

        }
    }

}
