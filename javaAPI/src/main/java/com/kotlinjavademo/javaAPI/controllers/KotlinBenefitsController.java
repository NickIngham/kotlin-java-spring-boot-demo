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
@RequestMapping("/kotlin-benefits")
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

  // #### Eager Lists ####
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

  // the nicere way in java is you can convert to a stream and then back to a list
  @GetMapping("/lists-stream")
  public List<Integer> listToStream(){
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      list.add(i * 2);
    }
    return list.stream()
        .filter(integer -> integer % 4 == 0)
        .collect(Collectors.toList());
  }


  //#### Lazy Streams ####
  @GetMapping("/streams")
  public Stream<Integer> streams() {
    Stream<Integer> stream = Stream.iterate(0,integer -> integer).limit(100);
    return stream.filter(integer -> integer >= 20 && integer <= 40)
                .map(integer -> integer + 10 );
  }

  //#### switch statements ####

  @GetMapping("/switch")
  public String switches(){
    var input = 1;
    switch (input){
      case 0:
        return "switch statements in Java...";
      case 1:
        return "...are limited to a single variable...";
      default:
        return "...and constant value statements only";
    }
  }

}

//#### Default Values ####
// you can set default values with variables in the classes in java
// but then requires it requires a lot of constructors being written and getters and setters
class Person {
  private String title;
  private String firstName = null;
  private String lastName;
  private int age;

  public Person(String title, String firstName, String lastName, int age) {
    this.title = title;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public Person(String title, String lastName, int age) {
    this.title = title;
    this.lastName = lastName;
    this.age = age;
  }

  public Person(String title, String firstName, String lastName) {
    this.title = title;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = -1;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
