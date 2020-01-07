package com.kotlinjavademo.kotlin.controllers

import com.kotlinjavademo.kotlin.services.JavaService
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException

@RestController
@RequestMapping("/java-benefits")
class KotlinBenefitsController {
    @GetMapping("/hey-buddy")
    fun helloWorld() : String = "Hey Buddy! Love, Kotlin"

    //null is a separate type
    @GetMapping("/nullable")
    fun nullOperators(): String? {
        // String (non-null String) and String? (nullable String) are two distinct types in Kotlin.
        // This means that the program will not throw a null pointer exception
        // If necessary you can add the operator '!!' after the variable to force a NPE(NullPointerException) check and throw an exception if null

        // if the return type is changed to to just 'String' then the program will not compile
        val toggle = false
        return if (toggle) "string" else null
    }

    // Eager Lists, behave like streams but are executed immediately and the program will wait
    @GetMapping("/lists")
    fun streams() : List<Int>{
        val list = List(5){it * 2}
        return list.filter { it % 4 == 0}
    }

    //Lazy Sequences, the alternative to java streams useful for if you want to add multiple filters or maps
    @GetMapping("/sequences")
    fun sequences(): Sequence<Int>{
        val list = List(100){it}
        return list.asSequence()
                .filter { it in 20..40 }
                .map { it + 10 }
    }

//#### Switch statements ####
    @GetMapping("/switch")
    fun switch(): Any {
        val input:Any = 1
        when(input){
            is String -> return "The input is: $input"
            0 -> return input
            1 -> return 25 + 50
            throw IllegalArgumentException("input doesn't match any cases") -> return "Unreachable code"
        }
    }


    //interesting feature of when is that 'when' can be used without an argument.
    // In such case it acts as a nicer if-else chain: the conditions are Boolean expressions.
    // As always, the first branch that matches is chosen.
    // Given that these are boolean expression, it means that the first condition that results True is chosen.
    @GetMapping("/switch-no-argument")
    fun switchNoArgument(): String{
        val number = 5
        val text = "Hello"

        return when {
            number > 5 -> "Number is greater than 5"
            text.toLowerCase() == "hello" -> "Hi!"
            else -> "you hit the else block"
        }
    }

    // #### Integration with Java ####
    @GetMapping("/java-classes")
    fun javaClasses(): String {
        val javaService = JavaService()
        return javaService.javaMethod()
    }
}

//#### Default Values ####
// default values can be used so that parameters become optional for data classes, this can be use for data classes to avoid lots of constructors
data class Person (
        val title : String,
        val firstName : String? = null,
        val lastName : String,
        val age : Int = -1
)
//In summary, It has a better type system for enhanced safety and compile-time error checking.
// The fact alone that it is null-safe by default should be enough to justify the use of Kotlin over Java.
