package ru.otus.otuskotlin.phonesell.pa.common.be.models

inline class MpDemandIdModel(
    override val id: String
): IMpItemIdModel {
    companion object {
        val NONE = MpDemandIdModel("")
    }
}
