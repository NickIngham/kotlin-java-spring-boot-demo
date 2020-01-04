package com.kotlinjavademo.kotlin.entities

import com.kotlinjavademo.kotlin.models.Vehicle
import net.bytebuddy.implementation.bytecode.assign.TypeCasting
import javax.management.MBeanRegistration
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "vehicle")
class VehicleEntity(
        @Id val id : Long? = null,
        val registration: String,
        val make: String,
        val model: String,
        val modelYear: Int
) {
    fun toDto(): Vehicle = Vehicle(
            make = this.make,
            registration = this.registration,
            model = this.model,
            modelYear = this.modelYear
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