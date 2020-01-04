package com.kotlinjavademo.kotlin.models

import javax.management.MBeanRegistration

data class Vehicle(
        var make: String,
        var model: String,
        var modelYear: Int,
        var registration: String
)