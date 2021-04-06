package com.example.controllers

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import org.slf4j.LoggerFactory
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.DemandCrud
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpStubCase
import ru.otus.otuskotlin.phonesell.pa.transport.mappers.respondDemandGet
import ru.otus.otuskotlin.phonesell.pa.transport.mappers.respondPhoneList
import ru.otus.otuskotlin.phonesell.pa.transport.mappers.setQuery
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.ResponseStatusDto
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.*
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.*
import java.time.Instant

class MpDemandController ( private val crud:DemandCrud) {
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

            )
            pipelineContext.call.respond(response)

        } catch (e: Throwable){
            log.error ("Read chain error",e)
            MpResponseDemandCreate(
                responseId = "NewResp1",
                status = ResponseStatusDto.INTERNAL_SERVER_ERROR,
            )
        }

    }
    suspend fun read(pipelineContext: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request=pipelineContext.call.receive<MpMessage>() as MpRequestDemandRead
            //some logic
            val response:MpMessage=MpBeContext().run{
                stubCase = MpStubCase.DEMAND_READ_SUCCESS
                crud.read(setQuery(request))
                respondDemandGet().copy(
                    responseId = "123",
                    status = ResponseStatusDto.SUCCESS,
                    onRequest=request.requestId,
                    endTime=Instant.now().toString(),

                )
            }
            /*
            val response:MpMessage=MpResponseDemandRead(
                responseId = "123",
                onRequest = request.requestId,
                endTime=Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
            )*/
            pipelineContext.call.respond(response)

        } catch (e: Throwable){
            log.error ("Read chain error",e)
            MpResponseDemandRead(
                responseId = "",
                status = ResponseStatusDto.INTERNAL_SERVER_ERROR,
            )

        }

    }
    suspend fun update(pipelineContext: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request=pipelineContext.call.receive<MpMessage>() as MpRequestDemandUpdate
            //some logic
            val response:MpMessage=MpResponseDemandUpdate(
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
    suspend fun delete (pipelineContext: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request=pipelineContext.call.receive<MpMessage>() as MpRequestDemandDelete
            //some logic
            val response:MpMessage=MpResponseDemandDelete(
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

    suspend fun listPhones(pipelineContext: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request=pipelineContext.call.receive<MpMessage>() as MpRequestOffersList
            //some logic
            val response:MpMessage=MpBeContext().run{
                stubCase = MpStubCase.PHONE_OFFERS_SUCCESS
                crud.listPhones(setQuery(request))
                respondPhoneList().copy(
                    responseId = "123",
                    status = ResponseStatusDto.SUCCESS,
                    onRequest=request.requestId,
                    endTime=Instant.now().toString(),

                    )
            }
            /*
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
                            ),
                            memProcGrp =
                                MemProcTypeDto(
                                    cpu="Qualcomm Snapdragon 662, 2000 МГц",
                                    memory="64Гб",
                                    quantityCores="8",
                                    vRam="64",
                                    videoProc="Adreno 610"
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
            )*/
            pipelineContext.call.respond(response)

        } catch (e: Throwable){
            log.error ("Read chain error",e)

        }
    }

}
