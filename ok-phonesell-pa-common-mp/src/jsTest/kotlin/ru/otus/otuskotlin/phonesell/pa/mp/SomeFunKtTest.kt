import ru.otus.otuskotlin.phonesell.pa.mp.someFun
import kotlin.test.Test
import kotlin.test.assertTrue

internal class SomeFunKtTestJs{
    @Test
    fun someFunTest(){
        val str="SomeStr"
        assertTrue {
            someFun(str).contains("Js")
        }
    }
}