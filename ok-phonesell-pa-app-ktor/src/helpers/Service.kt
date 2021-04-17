package com.example.helpers

import com.example.services.DemandService
import io.ktor.http.cio.websocket.*
import kotlinx.coroutines.isActive
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandList
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandRead

suspend fun service(
    context: MpBeContext,
    query: MpMessage?,
    demandService: DemandService,
   // proposalService: ProposalService
): MpMessage? = when (query) {
    is MpRequestDemandRead -> demandService.read(context, query)

    else -> null
        // В дальнейшем здесь должен оказаться чейн обработки ошибок, и других событий

}
