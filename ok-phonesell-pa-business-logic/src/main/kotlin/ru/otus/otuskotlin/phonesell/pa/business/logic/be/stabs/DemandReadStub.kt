package ru.otus.otuskotlin.phonesell.pa.business.logic.be.stabs

import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.common.be.models.*
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.IOperation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.operation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.pipeline

object DemandReadStub:IOperation<MpBeContext> by pipeline ({
    startIf { stubCase != MpStubCase.NONE }

    operation {
        startIf { stubCase == MpStubCase.DEMAND_READ_SUCCESS }
        execute {
            responseDemand = MpDemandModel(
                id = MpDemandIdModel("test-id"),
                firstName = "Alexandr",
                lastName = "Petrov",
                contactPhone="+79213245777",
                email="a.sav210@gmail.com",
                products= mutableSetOf(
                    MpDemandProductsModel(
                        id = MpDemandProductsIdModel ("id1") ,
                        idProduct ="idProduct-1",
                        quantity = 2,
                        price = 50000.toBigDecimal(),
                    ),
                    MpDemandProductsModel(
                        id = MpDemandProductsIdModel ("Demand-2"),
                        idProduct ="idPrdouct-2",
                        quantity = 2,
                        price = 50000.toBigDecimal(),
                    ),
                )
            )
            status = MpBeContextStatus.FINISHING
        }
    }

})