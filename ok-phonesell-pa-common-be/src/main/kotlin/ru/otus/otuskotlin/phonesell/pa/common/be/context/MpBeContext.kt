package ru.otus.otuskotlin.phonesell.pa.common.be.context

import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandIdModel
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpDemandModel
import ru.otus.otuskotlin.phonesell.pa.common.be.models.MpOfferProductsModel

data class MpBeContext(
    var requestDemandId: MpDemandIdModel = MpDemandIdModel.NONE,
    var requestDemand: MpDemandModel = MpDemandModel.NONE,
    var responseDemand: MpOfferProductsModel = MpOfferProductsModel.NONE,
)
