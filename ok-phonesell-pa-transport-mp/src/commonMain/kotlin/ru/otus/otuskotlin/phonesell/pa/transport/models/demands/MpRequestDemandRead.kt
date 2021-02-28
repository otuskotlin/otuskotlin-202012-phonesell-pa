package ru.otus.otuskotlin.phonesell.pa.transport.models.demands

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.IMpDebug
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.IMpRequest
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage

@Serializable
@SerialName("MpRequestDemandRead")
data class MpRequestDemandRead(
    override val requestId: String?=null,
    override val onResponse: String?=null,
    override val startTime: String?=null,
    override val debug: IMpDebug?=null,
    val demandId: String?=null
): IMpRequest, MpMessage()