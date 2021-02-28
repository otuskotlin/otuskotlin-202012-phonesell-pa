package ru.otus.otuskotlin.phonesell.pa.common.be.models

data class MpDemandProductsModel(
    val id:  MpDemandProductsIdModel = MpDemandProductsIdModel.NONE,
    val idProduct: String = "",
    val quantity:  String = "",
    val price: Double = Double.NaN,
){
    companion object {
        val NONE = MpDemandProductsModel()
    }

}
