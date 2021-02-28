package ru.otus.otuskotlin.phonesell.pa.transport.models.demands

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
@Serializable
data class MpDemandCreateDto(
    override val lastName: String?,
    override val firstName: String?,
    override val contactPhone: String?,
    override val email: String?,
    override val products: Set<DemandProductsDto>?
):IMpDemandItemCreateDto,MpMessage()
