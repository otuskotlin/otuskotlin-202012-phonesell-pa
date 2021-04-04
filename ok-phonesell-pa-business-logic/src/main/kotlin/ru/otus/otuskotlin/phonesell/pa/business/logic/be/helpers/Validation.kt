package ru.otus.otuskotlin.phonesell.pa.business.logic.be.helpers

import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpError
import ru.otus.otuskotlin.phonesell.pa.kmp.pipelines.validation.ValidationBuilder
import ru.otus.otuskotlin.phonesell.pa.mp.validation.ValidationResult
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.Pipeline

fun Pipeline.Builder<MpBeContext>.validation(block: ValidationBuilder<MpBeContext>.() -> Unit) {
    execute(ValidationBuilder<MpBeContext>()
        .apply {
            startIf { status == MpBeContextStatus.RUNNING }
            errorHandler { vr: ValidationResult ->
                if (vr.isSuccess) return@errorHandler
                val errs = vr.errors.map { MpError(message = it.message) }
                errors.addAll(errs)
                status = MpBeContextStatus.FAILING
            }
        }
        .apply(block)
        .build())
}
