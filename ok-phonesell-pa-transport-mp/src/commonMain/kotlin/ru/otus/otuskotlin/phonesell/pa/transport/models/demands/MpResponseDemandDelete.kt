package ru.otus.otuskotlin.phonesell.pa.transport.models.demands

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.*
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.OfferProductsDto

@Serializable
@SerialName ("MpResponseDemandDelete")
data class MpResponseDemandDelete(
    override val responseId: String?=null,
    override val onRequest: String?=null,
    override val endTime: String?=null,
    override val errors: List<ErrorDto>?=null,
    override val status: ResponseStatusDto?=null,
    override val debug: Debug?=null,
    //val offers: OfferProductsDto? = null,
    val demand: MpDemandDto? = null,
    val deleted: Boolean? = null,
) : IMpResponse,MpMessage(){
    @Serializable
    data class Debug(
        override val mode: MpWorkModeDto?
    ) : IMpDebug
}
