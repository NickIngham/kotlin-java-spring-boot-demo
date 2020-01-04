package com.kotlinjavademo.kotlin.repositories

import com.kotlinjavademo.kotlin.entities.VehicleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface VehicleRepository : JpaRepository<VehicleEntity, Long> {
    fun getVehicleByRegistration(registration: String): VehicleEntity?
}