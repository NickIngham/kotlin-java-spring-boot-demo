package com.kotlinjavademo.kotlin.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/java-benefits")
class KotlinBenefitsController {
    @GetMapping("/hey-buddy")
    fun helloWorld() : String = "Hey Buddy! Love, Kotlin"

    //null is a separate type
    @GetMapping("/nullable")
    fun nullable() : String? {
        val switch = false
        return if (switch) "String" else null
    }

    // streams
    @GetMapping("/streams")
    fun streams() : List<Int>{
        val list = List(5){it * 2}
        return list.filter { it % 4 == 0}
    }

    //Lazy sequences
    @GetMapping("/multi-step-collections")
    fun multiStepCollections(): List<Int>{
        val list = List(100){it}
        return list.asSequence()
                .filter { it >= 20 && it >= 40  }
                .map { it + 10 }
                .toList()
    }

    // iterators; foreach
    @GetMapping("/iterators")
    fun iterators() {
        val list = List(20){it}
        for (element in list){
            if (element % 3 == 0)
                println("Fizz")
        }
    }
    // using Java Classes

    // can convert to jvm bytecode
}

// default values can be used so that parameters become optional for data classes, this can be
data class Person (
        val title : String,
        val firstName : String? = null,
        val lastName : String,
        val age : Int = -1
)