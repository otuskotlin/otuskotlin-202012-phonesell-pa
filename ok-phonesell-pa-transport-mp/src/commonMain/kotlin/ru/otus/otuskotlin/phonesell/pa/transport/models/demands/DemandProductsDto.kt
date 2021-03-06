package ru.otus.otuskotlin.phonesell.pa.transport.models.demands

import kotlinx.serialization.Serializable

@Serializable
class DemandProductsDto (
    val id:        String? = null,
    val idProduct: String?=null,
    val quantity:  String?=null,
    val price: Double?=null,
)
