package com.example

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.*
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.MpRequestOffersList
import ru.otus.otuskotlin.phonesell.pa.transport.models.offers.MpResponseOffersList

val jsonConfig: Json by lazy {
    Json {
        prettyPrint = true
        serializersModule = SerializersModule {
            polymorphic(MpMessage::class) {
                subclass(MpRequestDemandCreate::class)
                subclass(MpRequestDemandRead::class)
                subclass(MpRequestDemandDelete::class)
                subclass(MpRequestDemandUpdate::class)
                subclass(MpRequestDemandList::class)
                subclass(MpResponseDemandCreate::class)
                subclass(MpResponseDemandRead::class)
                subclass(MpResponseDemandDelete::class)
                subclass(MpResponseDemandUpdate::class)
                subclass(MpResponseDemandList::class)
                subclass(MpRequestOffersList::class)
                subclass(MpResponseOffersList::class)
            }
        }
        classDiscriminator = "type"
    }
}
