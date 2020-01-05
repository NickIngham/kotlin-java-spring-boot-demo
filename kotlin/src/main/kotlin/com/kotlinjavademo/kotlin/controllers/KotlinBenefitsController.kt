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

    //no static member. must use companion objects as a work around,  the companion is a singleton instance

    // all classes are default final, unless you use the open keyword so that the class can be extended

    // constructor galore, but if your simply setting values in the constructor then default values can be used so that parameters become optional

    //data classes, great but half baked, cannot extend data classes, not even using the 'open' keyword

    // summary might be that use the best of both. try out a hybrid, if you prefer data classes in kotlin, then make the data classes in your project kotlin but write the bussiness logic in Java

}
