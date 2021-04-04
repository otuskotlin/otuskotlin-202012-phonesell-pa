package ru.otus.otuskotlin.phonesell.pa.mp.validation.validators

import ru.otus.otuskotlin.phonesell.pa.mp.validation.IValidator
import ru.otus.otuskotlin.phonesell.pa.mp.validation.ValidationFieldError
import ru.otus.otuskotlin.phonesell.pa.mp.validation.ValidationResult


class ValidatorStringNonEmpty(
    private val field: String = "",
    private val message: String = "String must not be empty"
): IValidator<String?> {

    override fun validate(sample: String?): ValidationResult {
        return if (sample.isNullOrBlank()) {
            ValidationResult(
                errors = listOf(
                    ValidationFieldError(
                        field = field,
                        message = message,
                    )
                )
            )

        } else {
            ValidationResult.SUCCESS
        }
    }

}
