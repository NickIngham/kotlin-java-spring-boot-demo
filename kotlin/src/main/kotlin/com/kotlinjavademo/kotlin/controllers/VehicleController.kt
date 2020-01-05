package com.kotlinjavademo.kotlin.controllers

import com.kotlinjavademo.kotlin.models.Vehicle
import com.kotlinjavademo.kotlin.services.VehicleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vehicles")
class VehicleController (
        @Autowired
        private val vehicleService: VehicleService
) {
    @GetMapping
    fun getAllVehicles() = vehicleService.retrieveAllVehicles()

    @GetMapping("/{registration}")
    fun getVehicleByRegistration(@PathVariable registration: String) : Vehicle? = vehicleService.getVehicleByRegistration(registration)

    @PostMapping("/add")
    fun addVehicle(@RequestBody vehicle: Vehicle) : Vehicle = vehicleService.addVehicle(vehicle)

    @PostMapping("/update")
    fun updateVehicle(@RequestBody vehicle: Vehicle) : Vehicle? = vehicleService.updateVehicle(vehicle)
}

