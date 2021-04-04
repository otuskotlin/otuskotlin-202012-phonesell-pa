package ru.otus.otuskotlin.phonesell.pa.mp.validation
interface IValidator<T> {
    infix fun validate(sample: T): ValidationResult
}
