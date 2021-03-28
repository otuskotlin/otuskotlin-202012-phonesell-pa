package ru.otus.otuskotlin.phonesell.pa.business.logic.be.operations

import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.IOperation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.operation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.pipeline

object PipeLineFinalizeOperation: IOperation<MpBeContext> by pipeline({

    operation {
        startIf {status in setOf(MpBeContextStatus.RUNNING, MpBeContextStatus.FINISHING)}
        execute { status= MpBeContextStatus.SUCCESS }
    }
    operation {
        startIf { status!= MpBeContextStatus.SUCCESS }
        execute { status= MpBeContextStatus.ERROR }
    }
})