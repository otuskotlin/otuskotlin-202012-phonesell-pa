package ru.otus.otuskotlin.phonesell.pa.pipelines.kmp

interface IOperationBuilder<T> {
    fun build(): IOperation<T>
}
