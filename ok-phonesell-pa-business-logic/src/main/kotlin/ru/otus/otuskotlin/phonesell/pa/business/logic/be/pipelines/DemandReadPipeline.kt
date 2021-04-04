package ru.otus.otuskotlin.phonesell.pa.business.logic.be.pipelines

import ru.otus.otuskotlin.phonesell.pa.business.logic.be.helpers.validation
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.operations.PipeLineFinalizeOperation
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.operations.PipelineInitOperation
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.stabs.DemandReadStub
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandIdModel
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandModel
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpStubCase

import ru.otus.otuskotlin.phonesell.pa.mp.validation.validators.ValidatorStringNonEmpty
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.IOperation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.operation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.pipeline

object DemandReadPipeline:IOperation<MpBeContext> by pipeline ({
    execute ( PipelineInitOperation )

    execute(DemandReadStub)
    validation {
        validate<String?> {
            on { requestDemandId.id }
            validator(ValidatorStringNonEmpty(
                field = "demand-id",
                message = "Demand ID requested must not be empty"
            ))
        }
    }
    execute (PipeLineFinalizeOperation)
    //Repository
})