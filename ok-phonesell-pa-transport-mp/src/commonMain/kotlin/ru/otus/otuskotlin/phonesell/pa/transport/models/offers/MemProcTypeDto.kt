package ru.otus.otuskotlin.phonesell.pa.transport.models.offers

import kotlinx.serialization.Serializable

@Serializable
data class MemProcTypeDto (
    val cpu :String?=null,
    val memory :String?=null,
    val quantityCores :String?=null,
    val vRam:String?=null,
    val videoProc :String?=null,
)


