package ru.otus.otuskotlin.phonesell.pa.kmp.pipelines.validation

import ru.otus.otuskotlin.phonesell.pa.kmp.pipelines.validation.IValidationOperation
import ru.otus.otuskotlin.phonesell.pa.kmp.pipelines.validation.PipelineValidation
import ru.otus.otuskotlin.phonesell.pa.mp.validation.ValidationResult
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.IOperation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.IOperationBuilder
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.PipelineDsl
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.Predicate

@PipelineDsl
class ValidationBuilder<C>: IOperationBuilder<C> {
    private var checkPrecondition: Predicate<C> = { true }
    private var errorHandler: C.(ValidationResult) -> Unit = {}
    private val validators: MutableList<IValidationOperation<C, *>> = mutableListOf()

    fun startIf(block: Predicate<C>) {
        checkPrecondition = block
    }

    fun errorHandler(block: C.(ValidationResult) -> Unit) {
        errorHandler = block
    }

    fun <T> validate(block: ValidationOperationBuilder<C, T>.() -> Unit) {
        val builder = ValidationOperationBuilder<C,T>(errorHandler).apply(block)
        validators.add(builder.build())
    }

    override fun build(): IOperation<C> = PipelineValidation(validators)

}
