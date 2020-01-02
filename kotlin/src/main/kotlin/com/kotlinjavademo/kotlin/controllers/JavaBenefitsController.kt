package com.kotlinjavademo.kotlin.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("java-benefits/")
class JavaBenefitsController {
    @GetMapping("hey-buddy")
    fun helloWorld() : String = "Hey Buddy! Love, Kotlin"
}