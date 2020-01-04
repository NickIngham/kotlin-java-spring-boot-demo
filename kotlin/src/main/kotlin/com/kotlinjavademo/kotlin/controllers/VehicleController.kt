package com.kotlinjavademo.kotlin.controllers

import com.kotlinjavademo.kotlin.services.VehicleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vehicles")
class VehicleController (
       private val vehicleService: VehicleService
) {
    @GetMapping("/{registration}")
    fun getVehicleByRegistration(@PathVariable registration: String) = vehicleService.getVehicleByRegistration(registration)
}

