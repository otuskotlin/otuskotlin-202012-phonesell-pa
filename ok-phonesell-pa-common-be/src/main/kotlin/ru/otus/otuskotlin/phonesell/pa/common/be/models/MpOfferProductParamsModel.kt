package ru.otus.otuskotlin.phonesell.pa.common.be.models

data class MpOfferProductParamsModel(
    var id: MpOfferProductParamsIdModel = MpOfferProductParamsIdModel.NONE,
    val nameParam: String = "",
    val valueParam: String = "",
    val description: String = "",
){
    companion object {
        val NONE = MpOfferProductParamsModel()
    }
}
