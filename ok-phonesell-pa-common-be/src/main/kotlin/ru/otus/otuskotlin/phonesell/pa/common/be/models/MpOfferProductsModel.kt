package ru.otus.otuskotlin.phonesell.pa.common.be.models

import java.math.BigDecimal

data class MpOfferProductsModel(
    val id: MpOfferProductsIdModel = MpOfferProductsIdModel.NONE,
    val brand: String = "",
    val model: String = "",
    val weight: String ="",
    val quantityStock: Int = 0,
    val description: String = "",
    val photo: String = "",
    val price: BigDecimal = BigDecimal.ZERO,
    val params: MutableSet<MpOfferProductParamsModel> = mutableSetOf(),
    val memProcType:MpProcMemTypeModel=MpProcMemTypeModel.NONE,
){
    companion object {
        val NONE = MpOfferProductsModel()
    }
}
