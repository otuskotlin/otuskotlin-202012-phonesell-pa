package ru.otus.otuskotlin.phonesell.pa.business.logic.be

import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext

class DemandCrud {
    suspend fun create(context: MpBeContext) {
       // DemandCreate.execute(context.apply(this::configureContext))
    }

    suspend fun read(context: MpBeContext) {
        //DemandRead.execute(context.apply(this::configureContext))
    }

    suspend fun update(context: MpBeContext) {
        //DemandUpdate.execute(context.apply(this::configureContext))
    }

    suspend fun delete(context: MpBeContext) {
        //DemandDelete.execute(context.apply(this::configureContext))
    }

    suspend fun offers(context: MpBeContext) {
        //DemandOffers.execute(context.apply(this::configureContext))
    }

    private fun configureContext(context: MpBeContext) {}

}
