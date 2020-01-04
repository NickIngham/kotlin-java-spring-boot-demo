package com.kotlinjavademo.kotlin.services

import com.kotlinjavademo.kotlin.entities.VehicleEntity
import com.kotlinjavademo.kotlin.models.Vehicle
import com.kotlinjavademo.kotlin.repositories.VehicleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VehicleService (
        @Autowired
        internal val vehicleRepository: VehicleRepository
) {
    fun getVehicleByRegistration(registration: String) : Vehicle?{
        return vehicleRepository.getVehicleByRegistration(registration)?.toDto()
    }

    fun retrieveAllVehicles(): List<Vehicle>{
        return vehicleRepository.findAll().map { it.toDto() }
    }

    fun addVehicle(vehicle: Vehicle) : Vehicle {
        return vehicleRepository.save(VehicleEntity.fromVehicle(vehicle)).toDto()
    }

    fun updateVehicle( vehicle: Vehicle) : Vehicle? {
        val currentVehicle = vehicleRepository.getVehicleByRegistration(registration = vehicle.registration)
        return if (currentVehicle != null ) vehicleRepository.save(VehicleEntity.fromVehicle(vehicle, currentVehicle)).toDto()
        else null
    }
}