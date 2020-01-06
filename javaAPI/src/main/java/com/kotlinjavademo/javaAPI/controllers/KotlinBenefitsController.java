package com.kotlinjavademo.javaAPI.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java-benefits")
class KotlinBenefitsController {
  @GetMapping("/hey-buddy")
  public String helloWorld() {
    return "Hey Buddy! Love, Kotlin";
  }

  //null is a separate type
  @GetMapping("/nullable")
  public String NullOperators() {
    //here we can still pass back null, but this may not be expected, but it still compiles
    //other times in java we will get a null pointer exception thrown at run time
    boolean toggle = false;
    return toggle? "string" : null;
  }

  // Eager Lists
  @GetMapping("/lists")
  public List<Integer> lists(){
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      list.add(i * 2);
    }
    List<Integer> filteredList = new ArrayList<>();
    for (int integer : list) {
      if (integer % 4 == 0)
        filteredList.add(integer);
    }
    return list.stream()
        .filter(integer -> integer % 4 ==0)
        .collect(Collectors.toList());
  }

  //Lazy Streams
  @GetMapping("/streams")
  fun streams(): List<Int>{
    val list = List(100){it}
    return list.asSequence()
        .filter { it >= 20 && it >= 40  }
                .map { it + 10 }
                .toList()
  }

  // iterators; foreach very similar to
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
