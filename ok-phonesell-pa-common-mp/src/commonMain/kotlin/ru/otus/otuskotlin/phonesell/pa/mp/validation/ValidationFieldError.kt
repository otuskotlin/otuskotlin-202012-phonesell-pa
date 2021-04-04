package ru.otus.otuskotlin.phonesell.pa.mp.validation
data class ValidationFieldError(
    override val message: String,
    override val field: String,
) : IValidationError, IValidationFieldError
