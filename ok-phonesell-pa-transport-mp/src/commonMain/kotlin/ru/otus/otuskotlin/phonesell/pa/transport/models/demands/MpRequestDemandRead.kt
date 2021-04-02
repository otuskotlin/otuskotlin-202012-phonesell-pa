package ru.otus.otuskotlin.phonesell.pa.transport.models.demands

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.IMpDebug
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.IMpRequest
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpWorkModeDto

@Serializable
@SerialName("MpRequestDemandRead")
data class MpRequestDemandRead(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    override val startTime: String? = null,
    override val debug: Debug? = null,
    val demandId: String? = null,
    val stubCase: StubCase? = StubCase.SUCCESS,
): IMpRequest, MpMessage() {

    @Serializable
    data class Debug(
        override val mode: MpWorkModeDto?=null,
       // var stubCase: StubCase?=StubCase.SUCCESS,
    ) : IMpDebug

    @Serializable
    enum class StubCase {
        SUCCESS
    }
}