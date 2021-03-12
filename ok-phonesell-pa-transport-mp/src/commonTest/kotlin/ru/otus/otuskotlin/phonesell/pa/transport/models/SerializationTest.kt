package ru.otus.otuskotlin.phonesell.pa.transport.models

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import ru.otus.otuskotlin.phonesell.pa.transport.models.common.MpMessage
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandRead
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandUpdate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class SerializationTest {
    @Test
    fun requestSerialTest(){
        val request: MpMessage =MpRequestDemandRead(
            demandId = "demand-1"
        )
        val json= Json {
            prettyPrint=true
            serializersModule= SerializersModule {
                polymorphic(MpMessage::class){
                    subclass(MpRequestDemandRead::class)
                    subclass(MpRequestDemandUpdate::class)
                }
            }
            classDiscriminator="type"
        }
        val reqStr=json.encodeToString(MpMessage.serializer(),request)
        println (reqStr)
        assertTrue { reqStr.contains("demand-1") }
        val dto=json.decodeFromString(MpMessage.serializer(),reqStr)
        assertEquals("demand-1",(dto as? MpRequestDemandRead)?.demandId)
    }
}