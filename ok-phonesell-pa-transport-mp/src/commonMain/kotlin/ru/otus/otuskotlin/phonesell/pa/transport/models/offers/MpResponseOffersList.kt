package ru.otus.otuskotlin.phonesell.pa.transport.models.offers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.*

@Serializable
@SerialName("MpResponseOffersList")
data class MpResponseOffersList(
    override val responseId: String?,
    override val onRequest: String?,
    override val endTime: String?,
    override val errors: List<ErrorDto>?,
    override val status: ResponseStatusDto?,
    override val debug: Debug?,
    val offers: List<OfferProductsDto>? = null,
):IMpResponse,MpMessage(){
    @Serializable
    data class Debug(
        override val mode: MpWorkModeDto?
    ) : IMpDebug
}
