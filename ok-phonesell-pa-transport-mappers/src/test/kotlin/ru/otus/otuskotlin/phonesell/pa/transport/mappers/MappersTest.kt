package ru.otus.otuskotlin.phonesell.pa.transport.mappers

import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.DemandProductsDto
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpDemandCreateDto
import ru.otus.otuskotlin.phonesell.pa.transport.models.demands.MpRequestDemandCreate
import kotlin.test.Test
import kotlin.test.assertEquals

internal class MappersTest {

    @Test
    fun requestCreateMappingTest() {
        val request = MpRequestDemandCreate(
            createData = MpDemandCreateDto(
                lastName = "Petrov",
                firstName = "Alexandr",
                contactPhone = "+79213245777",
                email="a.sav210@gmail.com",
                products= mutableSetOf(
                    DemandProductsDto(
                        id = "Demand-1",
                        idProduct="idProduct-1",
                        quantity = "2",
                        price = "50000.40",
                    ),
                    DemandProductsDto(
                        id = "Demand-2",
                        idProduct="idPrdouct-2",
                        quantity = "не число",
                        price = "не число",
                    ),
                )
            )
        )
        val context = MpBeContext()
        context.setQuery(request)

        assertEquals("Petrov", context.requestDemand.lastName)
        assertEquals(2, context.requestDemand.products.size)
        with(context.requestDemand.products.elementAt(0)){
            assertEquals("50000.40".toBigDecimal(),price)
        }
        with(context.requestDemand.products.elementAt(1)){
            assertEquals("0".toBigDecimal(),price)
        }
        with(context.requestDemand.products.elementAt(0)){
            assertEquals("2".toInt(),quantity)
        }
        with(context.requestDemand.products.elementAt(1)){
            assertEquals("0".toInt(),quantity)
        }

    }
}


