package ru.otus.otuskotlin.phonesell.pa.kmp.pipelines.validation


import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.Pipeline

fun <C> Pipeline.Builder<C>.validation(block: ValidationBuilder<C>.() -> Unit) {
    execute(ValidationBuilder<C>().apply(block).build())
}
