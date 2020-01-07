package com.kotlinjavademo.kotlin.controllers

import com.kotlinjavademo.kotlin.entities.VehicleEntity
import com.kotlinjavademo.kotlin.models.Vehicle
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin-benefits")
class JavaBenefitsController{

    //no static member. must use companion objects as a work around,  the companion object is a singleton instance of the class and not the class itself
    @GetMapping("/static-members")
    fun staticMembers() : VehicleEntity {
        val vehicle = Vehicle("test","test", 1, "test")
        return VehicleEntity.fromVehicle(vehicle)
    }
}

//#### INHERITANCE ####
// all classes and functions are final by default, unless you use the 'open' keyword so that the class/function can be extended, depending on your perspective this can be an advantage or disadvantage
open class Animal {
    open fun speak() : String {
        return "………"
    }
}

class Dog : Animal() {
    override fun speak(): String {
        return "Woof!"
    }
}

//#### DATA CLASSES ####
// data classes, great but half baked, for example cannot extend data classes, not even using the 'open' keyword
// The reasoning behind the decision was that things might break (in particular in the clone utilities) when you try to introduce inheritance.
data class ParentClass(val variable : String)

// If you uncomment the line below there will be a compilation error
// data class ChildClass(val childVariable : String) : ParentClass


// #### constructor galore ####
//  for classes and we cannot use lombok annotations for @AllArgsConstructor and @NoArgsConstructor
// primary constructor
class PersonA(val firstName: String, val lastName: String) { }

// regular constructor
class PersonB {

    val firstName: String
    val lastName: String

    constructor(firstName: String, lastName: String){
        this.firstName = firstName
        this.lastName = lastName
    }

    constructor(firstName: String){
        this.firstName = firstName
        lastName = ""
        //do something else
    }


}
// In summary and the biggest advantage; you can use the best of both languages in the same program. try out a hybrid, if you prefer data classes in kotlin, then make the data classes in your project kotlin but write the business logic in Java
// Kotlin makes it easier to write code that is short and concise, but it can also be used to produce a mess of seemingly random character combinations