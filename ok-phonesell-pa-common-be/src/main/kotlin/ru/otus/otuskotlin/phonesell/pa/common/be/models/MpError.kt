package ru.otus.otuskotlin.phonesell.pa.common.be.models

data class MpError(
    override val code: String = "",
    override val group: IMpError.Group = IMpError.Group.NONE,
    override val field: String = "",
    override val level: IMpError.Level = IMpError.Level.ERROR,
    override val message: String = ""
) : IMpError
