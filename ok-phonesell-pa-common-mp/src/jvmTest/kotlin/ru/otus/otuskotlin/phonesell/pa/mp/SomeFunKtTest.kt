package ru.otus.otuskotlin.phonesell.pa.mp

import org.junit.Assert.*
import org.junit.Test

internal class SomeFunKtTestJvm{
    @Test
    fun someFunTest() {
        val str = "SomeStr "
        kotlin.test.assertTrue {
            someFun(str).contains("Jvm")
        }
    }
}
