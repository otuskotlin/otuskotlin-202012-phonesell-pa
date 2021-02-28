package ru.otus.otuskotlin.phonesell.pa.common.be.models

data class MpDemandModel(
     val id: MpDemandIdModel = MpDemandIdModel.NONE,
     val lastName:  String = "",
     val firstName: String = "",
     val contactPhone: String = "",
     val email: String = "",
     val products: MutableSet<MpDemandProductsModel> = mutableSetOf(),
    ) {
    companion object {
        val NONE = MpDemandModel()
    }
}
