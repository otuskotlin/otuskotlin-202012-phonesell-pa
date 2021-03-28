package ru.otus.otuskotlin.phonesell.pa.business.logic.be.stabs

import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandIdModel
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandModel
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpStubCase
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.IOperation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.operation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.pipeline

object DemandReadStub:IOperation<MpBeContext> by pipeline ({
    startIf { stubCase != MpStubCase.NONE }

    operation {
        startIf { stubCase == MpStubCase.DEMAND_READ_SUCCESS }
        execute {
            responseDemand = MpDemandModel(
                id = MpDemandIdModel("test-id"),
                firstName = "Alexandr",
                lastName = "Petrov",
                contactPhone="+79213245777"
            )
            status = MpBeContextStatus.FINISHING
        }
    }

})