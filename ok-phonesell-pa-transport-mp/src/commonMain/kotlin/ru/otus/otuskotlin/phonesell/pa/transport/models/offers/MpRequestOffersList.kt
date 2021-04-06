package ru.otus.otuskotlin.phonesell.pa.transport.models.offers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.*

@Serializable
@SerialName("MpRequestOffersList")
data class MpRequestOffersList(
    override val requestId: String?=null,
    override val onResponse: String?=null,
    override val startTime: String?=null,
    override val debug: Debug?=null,
    val demandId: String? = null,
    val stubCase: StubCase? = StubCase.SUCCESS,

    ):IMpRequest,MpMessage(){
    @Serializable
    data class Debug(
        override val mode: MpWorkModeDto?
    ) : IMpDebug

    @Serializable
    enum class StubCase {
        SUCCESS
    }
}

