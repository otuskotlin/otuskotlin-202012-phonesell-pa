package ru.otus.otuskotlin.phonesell.pa.transport.models.demands

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
@Serializable
data class MpDemandCreateDto(
    override val lastName: String?=null,
    override val firstName: String?=null,
    override val  contactPhone: String?=null,
    override val email: String?=null,
    override val products: Set<DemandProductsDto>?=null
):IMpDemandItemCreateDto
