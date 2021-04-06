package ru.otus.otuskotlin.phonesell.pa.business.logic.be.pipelines

import ru.otus.otuskotlin.phonesell.pa.business.logic.be.helpers.validation
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.operations.PipeLineFinalizeOperation
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.operations.PipelineInitOperation
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.stabs.DemandListPhonesStub
import ru.otus.otuskotlin.phonesell.pa.business.logic.be.stabs.DemandReadStub
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.mp.validation.validators.ValidatorStringNonEmpty
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.IOperation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.pipeline

object DemandListPhonesPipeline : IOperation<MpBeContext> by pipeline ({
    execute ( PipelineInitOperation )

    execute(DemandListPhonesStub)

    validation {
        validate<String?> {
            on {requestDemandId.id }
            validator(
                ValidatorStringNonEmpty(
                field = "id",
                message = "Phone's ID requested must not be empty"
            )
            )
        }
    }


    execute (PipeLineFinalizeOperation)
    //Repository
})