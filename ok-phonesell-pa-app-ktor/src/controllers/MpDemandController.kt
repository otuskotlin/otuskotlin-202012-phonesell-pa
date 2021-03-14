package com.example.controllers

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import org.slf4j.LoggerFactory
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.ResponseStatusDto
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandRead
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpResponseDemandRead
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.MpRequestOffersList
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.MpResponseOffersList
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.OfferProductsDto
import java.time.Instant

class MpDemandController {
    private val log=LoggerFactory.getLogger(this::class.java)!!

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
                            id = "Demand-1",
                            brand ="Apple",
                            model = "Iphone 11",
                            //quantityStock = 4,
                    ),
                )
            )
            pipelineContext.call.respond(response)

        } catch (e: Throwable){
            log.error ("Read chain error",e)

        }
    }

}
