package ru.otus.otuskotlin.phonesell.pa.common.be.context

import ru.otus.otuskotlin.phonesell.pa.common.be.models.*
import ru.otus.otuskotlin.phonesell.pa.common.be.repositories.EmptyUserSession
import ru.otus.otuskotlin.phonesell.pa.common.be.repositories.IUserSession
import java.time.Instant

data class MpBeContext(
    var timeStarted: Instant = Instant.MIN,
    var responseId: String = "",
    var onRequest: String = "",
    val userSession: IUserSession<*> = EmptyUserSession,
    var status: MpBeContextStatus=MpBeContextStatus.NONE,
    var errors: MutableList<IMpError> = mutableListOf(),
    var stubCase: MpStubCase = MpStubCase.NONE,
    var requestDemandId: MpDemandIdModel = MpDemandIdModel.NONE,
    var requestDemand: MpDemandModel = MpDemandModel.NONE,

    var responseDemand:MpDemandModel = MpDemandModel.NONE,
    //var listPhoneOffers: MpOfferProductsModel = MpOfferProductsModel.NONE,
    var responseListPhoneOffers: MutableList<MpOfferProductsModel> = mutableListOf(),
    var responseListPhoneOfferId:MpOfferProductsIdModel=MpOfferProductsIdModel.NONE,

    )
