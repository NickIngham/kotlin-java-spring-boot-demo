package com.kotlinjavademo.kotlin.entities

import com.kotlinjavademo.kotlin.models.Vehicle
import javax.persistence.*

@Entity
@Table(name = "vehicle")
class VehicleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long? = null,
        val registration: String,
        val make: String,
        val model: String,
        val modelYear: Int
) {
    fun toDto(): Vehicle = Vehicle(
            make = this.make,
            model = this.model,
            modelYear = this.modelYear,
            registration = this.registration
    )
    companion object {
        fun fromVehicle(vehicle : Vehicle) = VehicleEntity(
                make = vehicle.make,
                model = vehicle.model,
                modelYear = vehicle.modelYear,
                registration = vehicle.registration
        )
        fun fromVehicle( vehicle: Vehicle, default: VehicleEntity) = VehicleEntity(
                id = default.id!!,
                make = vehicle.make ?: default.make,
                model = vehicle.make ?: default.model,
                modelYear = vehicle.modelYear ?: default.modelYear,
                registration = vehicle.registration ?: default.registration
        )
     }
}