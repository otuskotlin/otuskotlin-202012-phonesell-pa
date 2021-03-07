package ru.otus.otuskotlin.phonesell.pa.transport.models.phones

import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.OfferProductParamsDto

data class MpOfferPhoneDto (
    val id: String? = null,
    val brand: String? = null,
    val model: String? = null,
    val quantityStock: Double?=null,
    val description: String?=null,
    val photo: String?=null,
    val price: String?=null,
)