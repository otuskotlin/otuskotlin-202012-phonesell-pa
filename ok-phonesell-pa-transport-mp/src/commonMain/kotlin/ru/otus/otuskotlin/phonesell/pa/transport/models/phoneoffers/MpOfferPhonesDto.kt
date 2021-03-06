package ru.otus.otuskotlin.phonesell.pa.transport.models.phoneoffers


import kotlinx.serialization.Serializable

@Serializable
data class MpOfferProductsDto (
    val id: String? = null,
    val brand: String? = null,
    val model: String? = null,
    val quantityStock: String?=null,
    val description: String?=null,
    val photo: String?=null,
    val price: String?=null,
    val guarantee:String?=null,
    val screen: Set<GroupScreenDto>?=null,
    val memoryProc: Set <GroupMemoryProcDto>?=null,
    val multimedia: Set<GroupMultimediaDto>?=null,
    val connection: Set<GroupConnectionDto>?=null,
    val otherfun  : Set <GroupOtherFunDto>?=null,
    val power     : Set <GroupPowerDto>?=null,
    //val params: MutableSet<OfferProductParamsDto>? = null,
)
