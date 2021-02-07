package ru.otus.otuskotlin.phonesell.pa.mp

import kotlin.math.max
import kotlin.math.min
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ValidateTest {
    @Test
    fun stringValidationTest(){
        val validator=ValidatorStringNotEmpty()
        val res=validator.validate("")
        "".validate(validator)
        assertEquals(false,res.isSuccess)
        assertTrue{
            res.errors.map {it.message}.first().contains("empty")
        }
    }

    @Test
    fun rangeValidationTest(){
        val validator=ValidatorInRange("age",2,5)
        val res=validator.validate(8)
        8.validate(validator)
        assertEquals(false,res.isSuccess)
        assertTrue{
          res.errors.map {it.message}.first().contains("range")
        }
    }

}

private fun <T: Comparable<T>> T.validate(validator: ValidatorInRange<T>) =validator.validate(this)


class ValidatorInRange<T: Comparable<T>>(val field: String, val min: T, val max: T) {
        fun validate(sample: T): ValidationResult =if (sample in min..max) {
            ValidationResult.SUCCESS
        }else{
            ValidationResult(
                errors = listOf(
                    ValidationError(
                        message = "Field $field with value $sample mast have value of range [$min,$max]"
                    )
                )
            )
        }
}

class ValidatorStringNotEmpty {
    fun validate(sample: String): ValidationResult =if (sample.isNullOrBlank()){
            ValidationResult(
                errors = listOf(
                    ValidationError(
                        message ="String \"$sample\" must not be empty or null"
                    )
                )
            )
        }else{
            ValidationResult.SUCCESS
        }
}

fun String.validate(validator: ValidatorStringNotEmpty)=validator.validate(this)

class ValidationResult (
    val errors: List<ValidationError>
    ) {
        val isSuccess :Boolean
            get()=errors.isEmpty() 
        companion object{
        val SUCCESS=ValidationResult(errors = emptyList())    
        }   
    }

data class ValidationError (
    val message :String
    ){
}


