package ru.otus.otuskotlin.phonesell.pa.common.be.context

enum class MpBeContextStatus {
    NONE,
    RUNNING,
    FINISHING,
    FAILING,
    SUCCESS,
    ERROR;

    val isError: Boolean
        get() = this in setOf(FAILING, ERROR)
}