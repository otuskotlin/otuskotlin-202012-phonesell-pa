package ru.otus.otuskotlin.phonesell.pa.pipelines.kmp

interface IOperation<T> {
    suspend fun execute(context: T)
}