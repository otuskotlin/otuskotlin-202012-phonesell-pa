package ru.otus.otuskotlin.phonesell.pa.common.be.models

data class MpProcMemTypeModel(
    val cpu :String?=null,
    val memory :String?=null,
    val quantityCores :String?=null,
    val vRam:String?=null,
    val videoProc :String?=null,
){
    companion object {
        val NONE = MpProcMemTypeModel()
    }
}
