package ru.otus.otuskotlin.phonesell.pa.common.be.models

import java.math.BigDecimal

data class MpDemandProductsModel(
    val id: MpDemandProductsIdModel = MpDemandProductsIdModel.NONE,
    val idProduct: String = "",
    val quantity:  Int = 0,
    val price: BigDecimal = BigDecimal.ZERO,
){
    companion object {
        val NONE = MpDemandProductsModel()
    }

}
