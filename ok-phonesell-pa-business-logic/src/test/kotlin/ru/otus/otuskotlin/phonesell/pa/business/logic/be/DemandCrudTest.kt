package ru.otus.otuskotlin.phonesell.pa.business.logic.be

import org.junit.Test
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandIdModel
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpOfferProductsModel
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpStubCase
import runBlockingTest
import kotlin.test.assertEquals

class DemandCrudTest {
    @Test
    fun  read(){
        val givenCrud=DemandCrud()
        val givenContext=MpBeContext(
            stubCase = MpStubCase.DEMAND_READ_SUCCESS,
            requestDemandId= MpDemandIdModel("test-id")

        )
        runBlockingTest { givenCrud.read(givenContext) }
        assertEquals(MpBeContextStatus.SUCCESS, givenContext.status)
        println(givenContext)
        with(givenContext.responseDemand) {
            assertEquals(MpDemandIdModel("test-id"), id)
            assertEquals("Petrov", lastName)
            assertEquals("Alexandr", firstName)
            assertEquals("+79213245777", contactPhone)
        }
    }
    @Test
    fun  listPhones(){
        val givenCrud=DemandCrud()
        val givenContext=MpBeContext(
            stubCase = MpStubCase.PHONE_OFFERS_SUCCESS,
            requestDemandId= MpDemandIdModel("test2-id")

        )
        runBlockingTest { givenCrud.listPhones(givenContext) }
        assertEquals(MpBeContextStatus.SUCCESS, givenContext.status)
        println(givenContext)
        assertEquals(2, givenContext.responseListPhoneOffers.size)
        with(givenContext.responseListPhoneOffers.elementAt(0)){
            assertEquals("90000".toBigDecimal(),price)
        }

    }

}