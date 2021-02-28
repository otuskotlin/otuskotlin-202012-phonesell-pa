package ru.otus.otuskotlin.phonesell.pa.common.be.models


interface IMpItemModel{
    val id: IMpItemIdModel
    val lastName: String
    val firstName: String
    val contactPhone: String
    val email: String
    val products: Set<MpDemandProductsModel>
}

