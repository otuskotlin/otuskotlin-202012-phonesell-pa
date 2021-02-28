package ru.otus.otuskotlin.phonesell.pa.transport.models.common

interface IMpResponse {
    val responseId: String?
    val onRequest: String?
    val endTime: String?
    val errors: List<ErrorDto>?
    val status: ResponseStatusDto?
    val debug: IMpDebug?
}