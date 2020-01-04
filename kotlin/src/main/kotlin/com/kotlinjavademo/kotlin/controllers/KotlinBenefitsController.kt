package com.kotlinjavademo.kotlin.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kotlin-benefits")
class KotlinBenefitsController{

    @GetMapping("/nulls")
    fun NullOperators(): String? {
        // String (non-null String) and String? (nullable String) are two distinct types in Kotlin.
        // This means that the program will not throw a null pointer exception
        // If necessary you can add the operator '!!' after the variable to force a NPE(NullPointerException) check and throw an exception if null

        // if the return type is changed to
        val switch = false
        return if (switch) "string" else null
    }
}
