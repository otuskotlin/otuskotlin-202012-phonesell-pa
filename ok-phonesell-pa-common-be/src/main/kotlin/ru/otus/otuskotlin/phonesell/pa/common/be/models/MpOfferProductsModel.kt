package ru.otus.otuskotlin.phonesell.pa.common.be.models

data class MpOfferProductsModel(
    val id: MpOfferProductsIdModel = MpOfferProductsIdModel.NONE,
    val brand: String = "",
    val model: String = "",
    //val quantityStock: Double = Double.NaN,
    val quantityStock: String = "",
    val description: String = "",
    val photo: String = "",
    val price: String = "",
    val params: MpOfferProductParamsModel= MpOfferProductParamsModel.NONE
){
    companion object {
        val NONE = MpOfferProductsModel()
    }
}
