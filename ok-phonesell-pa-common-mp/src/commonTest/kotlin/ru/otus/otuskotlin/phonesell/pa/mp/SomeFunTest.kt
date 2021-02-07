package ru.otus.otuskotlin.phonesell.pa.mp

import kotlin.test.Test
import kotlin.test.assertTrue

internal class SomeFunTest {
    @Test
    fun someFunTest(){
        val str="SomeFun"
        assertTrue {
            someFun(str).contains(str)
        }
    }
}