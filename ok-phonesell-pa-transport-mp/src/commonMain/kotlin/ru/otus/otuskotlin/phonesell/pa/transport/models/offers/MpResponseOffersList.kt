package ru.otus.otuskotlin.phonesell.pa.transport.models.offers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.*

@Serializable
@SerialName("MpResponseOffersList")
data class MpResponseOffersList(
    override val responseId: String?=null,
    override val onRequest: String?=null,
    override val endTime: String?=null,
    override val errors: List<ErrorDto>?=null,
    override val status: ResponseStatusDto?=null,
    override val debug: Debug?=null,
    val offers: MutableSet<OfferProductsDto>?= null,
):IMpResponse,MpMessage(){
    @Serializable
    data class Debug(
        override val mode: MpWorkModeDto?
    ) : IMpDebug
}
