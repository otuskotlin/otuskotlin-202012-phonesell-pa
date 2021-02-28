package ru.otus.otuskotlin.phonesell.pa.transport.models.offers

import kotlinx.serialization.Serializable

@Serializable
data class OfferProductParamsDto (
    val id: String? = null,
    val nameParam: String? = null,
    val valueParam: String?=null,
    val description: String? = null,
)
