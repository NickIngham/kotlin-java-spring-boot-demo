package com.kotlinjavademo.javaAPI.controllers;

import com.kotlinjavademo.javaAPI.entities.VehicleEntity;
import com.kotlinjavademo.javaAPI.models.Vehicle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java-benefits")
public class JavaBenefitsController {
    @GetMapping("hey-buddy")
    public String helloWorld(){
        return "Hey Buddy! Love, Java";
    }



    //no static member. must use companion objects as a work around,  the companion object is a singleton instance of the class and not the class itself
    @GetMapping("/static-members")
    public VehicleEntity staticMembers() {
        Vehicle vehicle = new Vehicle("test","test", 1, "test");
        return VehicleEntity.fromVehicle(vehicle);
    }
}

//#### INHERITANCE ####
// all classes and functions are final by default, unless you use the 'open' keyword so that the class/function can be extended, depending on your perspective this can be an advantage or disadvantage
class Animal {
    public String speak() {
    return "………";
    }
}

class Dog extends Animal {
    @Override
     public String speak(){
    return "Woof!";
    }
}

//#### DATA CLASSES ####
// In Java there is no explicit differences between a data class and a normal class
// so we have to manually add all our constructors, getters and setters
// we can make this easier if we had the Lombok dependency as we can use the following annotations
//@Data
class ParentClass {
    private String variable;
}

class ChildClass extends ParentClass {
    private String childVariable;
}


//#### Constructors ####

class PersonA {
    String firstName;
    String lastName;

    public PersonA(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonA() {
    }
}

//This can be made a lot easier using the Lombok dependency using the following annotations
// @AllArgsConstructor
// @NoArgsConstructor
class PersonB {
    private String firstName;
    private String lastName;
}
// In summary and the biggest advantage; you can use the best of both languages in the same program. try out a hybrid, if you prefer data classes in kotlin, then make the data classes in your project kotlin but write the business logic in Java
// Also, Java with the Lombok framework brings a few benefits over kotlin
// For Java Developers, I definitely recommend having a look at kotlin, you can using an existing spring api and write a few classes and integrate them into your existing app
