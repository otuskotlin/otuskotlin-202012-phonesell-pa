package ru.otus.otuskotlin.phonesell.pa.business.logic.be.operations

import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpStubCase
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.IOperation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.operation

object PipelineInitOperation:IOperation<MpBeContext> by operation ({
    startIf { stubCase == MpStubCase.NONE }
    execute { status=MpBeContextStatus.RUNNING }
})