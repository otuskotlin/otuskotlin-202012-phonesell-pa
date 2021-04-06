package ru.otus.otuskotlin.phonesell.pa.business.logic.be.stabs

import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContext
import ru.otus.otuskotlin.phonesell.pa.common.be.context.MpBeContextStatus
import ru.otus.otuskotlin.phonesell.pa.common.be.models.*
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.IOperation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.operation
import ru.otus.otuskotlin.phonesell.pa.pipelines.kmp.pipeline
import java.math.BigDecimal

object DemandListPhonesStub : IOperation<MpBeContext> by pipeline({
    startIf { stubCase != MpStubCase.NONE }

    operation {
        startIf { stubCase == MpStubCase.PHONE_OFFERS_SUCCESS }
        execute {
            responseListPhoneOffers.add(
                MpOfferProductsModel(
                    id =MpOfferProductsIdModel("test-id1"),
                    brand = "Apple",
                    model = "Iphone12",
                    quantityStock=2,
                    description = "test-description",
                    photo ="photo1",
                    price= BigDecimal("90000")
                ),
            )
            responseListPhoneOffers.add(
                MpOfferProductsModel(
                    id = MpOfferProductsIdModel("test-id1"),
                    brand = "Samsung",
                    model = "Galaxy10",
                    quantityStock=10,
                    description = "test-description",
                    photo ="photo2",
                    price= BigDecimal("45000")
                ),
            )
            status = MpBeContextStatus.FINISHING
        }
    }
})