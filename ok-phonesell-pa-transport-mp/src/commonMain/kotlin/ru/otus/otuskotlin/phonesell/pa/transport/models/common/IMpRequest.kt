package ru.otus.otuskotlin.phonesell.pa.transport.models.common

import ru.otus.otuskotlin.phonesell.pa.transport.models.common.IMpDebug

interface IMpRequest {
    val requestId: String?
    val onResponse: String?
    val startTime: String?
    val debug: IMpDebug?
}