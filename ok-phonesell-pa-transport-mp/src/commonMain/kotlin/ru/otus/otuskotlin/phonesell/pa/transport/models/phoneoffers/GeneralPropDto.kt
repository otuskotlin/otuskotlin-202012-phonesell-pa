package ru.otus.otuskotlin.phonesell.pa.transport.models.phoneoffers

data class GeneralPropDto(
    val os: String? = null,
    val weight: String? = null,
    val model: String? = null,
    val sims: Set<SimsTypeDto>? = null,
    val type: String?=null,
    val sizes: String?=null,
    val bodymaterial: String?=null,
)
