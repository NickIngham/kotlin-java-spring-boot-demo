package com.kotlinjavademo.javaAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("java-benefits/")
public class JavaBenefitsController {
    @GetMapping("hey-buddy")
    public String helloWorld(){
        return "Hey Buddy! Love, Java";
    }
}
