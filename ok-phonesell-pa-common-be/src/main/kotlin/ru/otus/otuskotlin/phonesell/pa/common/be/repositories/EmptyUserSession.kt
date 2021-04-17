package ru.otus.otuskotlin.phonesell.pa.common.be.repositories

object EmptyUserSession : IUserSession<Any> {
    override val fwSession = object {}
}
