package ru.otus.otuskotlin.phonesell.pa.business.logic.be

import kotlinx.coroutines.runBlocking
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.pipelines.DemandListPhonesPipeline
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.pipelines.DemandReadPipeline
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandIdModel
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal  class DemandReadValidation {

    @Test
    fun `demandId success non-empty`() {
        val ctx = MpBeContext(
            requestDemandId = MpDemandIdModel("123")
        )

        runBlocking {
            DemandReadPipeline.execute(ctx)
            assertEquals(MpBeContextStatus.SUCCESS, ctx.status)
            assertEquals(0, ctx.errors.size)
        }
    }

    @Test
    fun `demandId fails empty`() {
        val ctx = MpBeContext(
            requestDemandId = MpDemandIdModel("")
        )

        runBlocking {
            DemandReadPipeline.execute(ctx)
            assertEquals(MpBeContextStatus.ERROR, ctx.status)
            assertTrue { ctx.errors.first().message.contains("empty") }
        }
    }

    @Test
    fun `list demandId fails  empty`() {
        val ctx = MpBeContext(
            requestDemandId = MpDemandIdModel("")
        )

        runBlocking {
            DemandListPhonesPipeline.execute(ctx)
            assertEquals(MpBeContextStatus.ERROR, ctx.status)
            assertTrue { ctx.errors.first().message.contains("empty") }
        }
    }
}