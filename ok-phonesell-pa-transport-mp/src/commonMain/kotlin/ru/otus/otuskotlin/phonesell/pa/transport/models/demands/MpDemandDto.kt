package ru.otus.otuskotlin.phonesell.pa.transport.models.demands

import kotlinx.serialization.Serializable

@Serializable
data class MpDemandDto(
    override val lastName: String? =null,
    override val firstName: String? =null,
    override val contactPhone: String?=null,
    override val email: String?=null,
    override val products: Set<DemandProductsDto>?=null,
    override val id: String?=null,
):IMpDemandItemDto
