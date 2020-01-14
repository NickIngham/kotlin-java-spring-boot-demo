package com.kotlinjavademo.kotlin.services

import com.kotlinjavademo.kotlin.entities.VehicleEntity
import com.kotlinjavademo.kotlin.models.Vehicle
import com.kotlinjavademo.kotlin.repositories.VehicleRepository
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

internal class VehicleServiceTest {

    @InjectMocks
    lateinit var vehicleService: VehicleService

    @Mock
    lateinit var vehicleRepository: VehicleRepository

    @BeforeEach
    fun setup() = MockitoAnnotations.initMocks(this)

    @Test
    fun getVehicleByRegistration() {
        val registration = "LR20DFR"
        val expected = Vehicle(make = "Land Rover", model = " Defender", modelYear = 2020, registration = registration)
        val vehicle = Vehicle(make = "Land Rover", model = " Defender", modelYear = 2020, registration = registration)
        val entity = VehicleEntity.fromVehicle(vehicle)
        `when`(vehicleRepository.getVehicleByRegistration(registration)).thenReturn(entity)

        val result = vehicleService.getVehicleByRegistration(registration)

        assertTrue(result == expected)
    }

    @Test
    fun retrieveAllVehicles() {
        val vehiclesList = buildVehiclesList()
        val entityList = buildVehicleEntityList()
        `when`(vehicleRepository.findAll()).thenReturn(entityList)

        val result = vehicleService.retrieveAllVehicles()

        assertTrue(vehiclesList.containsAll(result))
        assertTrue(result.containsAll(vehiclesList))
    }

    @Test
    fun addVehicle() {
        val registration = "LR20DFR"
        val expected = Vehicle(make = "Land Rover", model = " Defender", modelYear = 2020, registration = registration)
        val vehicle = Vehicle(make = "Land Rover", model = " Defender", modelYear = 2020, registration = registration)
        val entity = VehicleEntity.fromVehicle(vehicle)
        `when`(vehicleRepository.save(any<VehicleEntity>())).thenReturn(entity)

        val result = vehicleService.addVehicle(vehicle)

        assertTrue(result == expected)
    }

    @Test
    fun updateVehicle_whenTheVehicleExistsInDb() {
        val registration = "LR20DFR"
        val expected = Vehicle(make = "Land Rover", model = " Defender", modelYear = 2020, registration = registration)
        val vehicle = Vehicle(make = "Land Rover", model = " Defender", modelYear = 2020, registration = registration)
        val entity = VehicleEntity(id = 1, make = "Land Rover", model = " Defender", modelYear = 2020, registration = registration)

        `when`(vehicleRepository.getVehicleByRegistration(entity.registration)).thenReturn(entity)
        `when`(vehicleRepository.save(any<VehicleEntity>())).thenReturn(entity)

        val result = vehicleService.updateVehicle(vehicle)

        verify(vehicleRepository).save(any<VehicleEntity>())
        assertTrue(result == expected)
    }

    @Test
    fun updateVehicle_whenTheVehicleDoesNotExistInDb() {
        val registration = "LR20DFR"
        val expected = Vehicle(make = "Land Rover", model = " Defender", modelYear = 2020, registration = registration)
        val vehicle = Vehicle(make = "Land Rover", model = " Defender", modelYear = 2020, registration = registration)
        val entity = VehicleEntity(id = 1, make = "Land Rover", model = " Defender", modelYear = 2020, registration = registration)

        `when`(vehicleRepository.getVehicleByRegistration(entity.registration)).thenReturn(null)

        val result = vehicleService.updateVehicle(vehicle)
        assertTrue(result == null)
    }

    private fun buildVehiclesList(): List<Vehicle> {
        return listOf(
                Vehicle(make = "Land Rover", model = " Defender", modelYear = 2020, registration = "LR20DFR"),
                Vehicle(make = "Jaguar", model = " XF", modelYear = 2020, registration = "JA20GXF"),
                Vehicle(make = "Land Rover", model = " Discovery", modelYear = 2020, registration = "LR20DSC")
        )
    }

    private fun buildVehicleEntityList(): List<VehicleEntity> {
        return listOf(
                VehicleEntity(id = 1, make = "Land Rover", model = " Defender", modelYear = 2020, registration = "LR20DFR"),
                VehicleEntity(id = 2, make = "Jaguar", model = " XF", modelYear = 2020, registration = "JA20GXF"),
                VehicleEntity(id = 3, make = "Land Rover", model = " Discovery", modelYear = 2020, registration = "LR20DSC")
        )
    }

}
