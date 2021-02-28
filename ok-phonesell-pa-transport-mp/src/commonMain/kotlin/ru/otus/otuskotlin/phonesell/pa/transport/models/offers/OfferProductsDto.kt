package ru.otus.otuskotlin.phonesell.pa.transport.models.offers

import kotlinx.serialization.Serializable

@Serializable
data class OfferProductsDto (
    val id: String? = null,
    val brand: String? = null,
    val model: String? = null,
    val quantityStock: Double?=null,
    val description: String?=null,
    val photo: String?=null,
    val params: MutableSet<OfferProductParamsDto>? = null,
)
