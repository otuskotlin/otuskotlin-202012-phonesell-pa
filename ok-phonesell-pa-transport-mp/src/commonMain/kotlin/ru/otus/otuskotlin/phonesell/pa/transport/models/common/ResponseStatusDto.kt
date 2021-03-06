package ru.otus.otuskotlin.phonesell.pa.transport.models.common

import kotlinx.serialization.Serializable

@Serializable
enum class ResponseStatusDto {
    SUCCESS,
    BAD_REQUEST,
    INTERNAL_SERVER_ERROR,
    NOT_FOUND,
}
