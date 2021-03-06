package ru.otus.otuskotlin.phonesell.pa.transport.models.demands

import kotlinx.serialization.Serializable

@Serializable
data class MpDemandDto(
    override val lastName: String?,
    override val firstName: String?,
    override val contactPhone: String?,
    override val email: String?,
    override val products: Set<DemandProductsDto>?,
    override val id: String?
):IMpDemandItemDto
