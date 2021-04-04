package ru.otus.otuskotlin.phonesell.pa.kmp.pipelines.validation
import ru.otus.otuskotlin.phonesell.pa.kmp.pipelines.validation.DefaultValidationOperation
import ru.otus.otuskotlin.phonesell.pa.kmp.pipelines.validation.IValidationOperation
import ru.otus.otuskotlin.phonesell.pa.mp.validation.IValidator
import ru.otus.otuskotlin.phonesell.pa.mp.validation.ValidationResult
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.PipelineDsl

@PipelineDsl
class ValidationOperationBuilder<C, T>(
    private var errorHandler: C.(ValidationResult) -> Unit = {}
) {
    private lateinit var onBlock: C.() -> T
    private lateinit var validator: IValidator<T>
    fun validator(validator: IValidator<T>) {
        this.validator = validator
    }
    fun on(block: C.() -> T) {
        onBlock = block
    }
    fun build(): IValidationOperation<C, T> {
        return DefaultValidationOperation(
            validator = validator,
            onBlock = onBlock,
            errorHandler = errorHandler
        )
    }
}
