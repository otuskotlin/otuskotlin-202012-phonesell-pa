package ru.otus.otuskotlin.phonesell.pa.mp

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
    @Test
    fun  validatorListTest(){

        val child=Child (age=10,name="")
        val validator =ValidatorChild( )
        val res=validator.validate(child)
        assertEquals(false,res.isSuccess)
        assertTrue("contains empty error "){
            res.errors.filter {it.message.contains("empty")}.isNotEmpty()
        }
        assertTrue("contains range error "){
            res.errors.filter {it.message.contains("empty")}.isNotEmpty()
        }
    }

}
data class Child (
    val age:Int,
    val name:String
)
class ValidatorChild:IValidator<Child> {
    val validators: List<IValidator<*>> = listOf(
        ValidatorInRange("age",2,5),
        ValidatorStringNotEmpty()
    )
    override fun validate(sample: Child): ValidationResult= ValidationResult(
        (validators[0] as ValidatorInRange<Int>).validate(sample.age),
        (validators[1] as ValidatorStringNotEmpty).validate(sample.name)
    )
}

interface IValidator <T>{
    fun validate(sample: T): ValidationResult
}

private fun <T: Comparable<T>> T.validate(validator: ValidatorInRange<T>) =validator.validate(this)


class ValidatorInRange<T: Comparable<T>>(val field: String, val min: T, val max: T):IValidator<T> {
        override fun validate(sample: T): ValidationResult =if (sample in min..max) {
            ValidationResult.SUCCESS
        }else{
            ValidationResult(
                errors = listOf(
                    ValidationFieldError(
                        field=field,
                        message = "Field $field with value $sample mast have value of range [$min,$max]",
                    )
                )
            )
        }
}

class ValidatorStringNotEmpty: IValidator<String> {
    override fun validate(sample: String): ValidationResult =if (sample.isNullOrBlank()){
            ValidationResult(
                errors = listOf(
                    ValidationDefaultError(
                        message ="String \"$sample\" must not be empty or null",
                        //field = field,
                    )
                )
            )
        }else{
            ValidationResult.SUCCESS
        }
}

fun String.validate(validator: ValidatorStringNotEmpty)=validator.validate(this)

class ValidationResult (
    val errors: List<IValidationError>
    ) {
    constructor(vararg errors: ValidationResult) : this(errors.flatMap { it.errors}.toList())

    val isSuccess :Boolean
            get()=errors.isEmpty()
        companion object{
        val SUCCESS=ValidationResult(errors = emptyList())
        }   
    }

data class ValidationDefaultError(
    override val message: String,
    ) :IValidationError {
}
data class ValidationFieldError(
    override val message: String,
    override val field: String,
) :IValidationFieldError {
}

interface IValidationError {
    val message:String
}

interface IValidationFieldError:IValidationError  {
    val field: String
}


