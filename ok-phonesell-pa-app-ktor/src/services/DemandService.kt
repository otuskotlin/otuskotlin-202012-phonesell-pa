package com.example.services
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.DemandCrud
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.transport.mappers.respondDemandGet
import ru.otus.otuskotlin.phonesell.pa.transport.mappers.setQuery
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandList
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandRead
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpResponseDemandList
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpResponseDemandRead

class DemandService(private val crud: DemandCrud) {


    suspend fun read(context: MpBeContext, query: MpRequestDemandRead?): MpResponseDemandRead = with (context) {
        query?.also { setQuery(it) }
        crud.read(this)
        return respondDemandGet()
    }



}
