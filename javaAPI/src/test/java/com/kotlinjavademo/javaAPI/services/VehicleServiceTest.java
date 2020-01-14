package com.kotlinjavademo.javaAPI.services;

import com.kotlinjavademo.javaAPI.entities.VehicleEntity;
import com.kotlinjavademo.javaAPI.models.Vehicle;
import com.kotlinjavademo.javaAPI.repositories.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VehicleServiceTest {

    @InjectMocks
    VehicleService vehicleService;

    @Mock
    VehicleRepository vehicleRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getVehicleByRegistration() {
        var registration = "LR20DFR";
        var expected = new Vehicle("Land Rover", " Defender", 2020, registration);
        var vehicle = new Vehicle("Land Rover", " Defender",2020, registration);
        var entity = VehicleEntity.fromVehicle(vehicle);
        when(vehicleRepository.getVehicleByRegistration(registration)).thenReturn(entity);

        var optionalResult = vehicleService.getVehicleByRegistration(registration);
        assertTrue(optionalResult.isPresent());
        var result = optionalResult.get();
        assertEquals(expected.getMake(),result.getMake());
        assertEquals(expected.getModel(),result.getModel());
        assertEquals(expected. getModelYear(),result.getModelYear());
        assertEquals(expected.getRegistration(),result.getRegistration());
    }

    @Test
    void retrieveAllVehicles() {
        List<Vehicle> vehiclesList = buildVehiclesList();
        List<VehicleEntity> entityList = buildVehicleEntityList();
        when(vehicleRepository.findAll()).thenReturn(entityList);

        var result = vehicleService.retrieveAllVehicles();
        vehiclesList.sort(Comparator.comparing(Vehicle::getRegistration));
        result.sort(Comparator.comparing(Vehicle::getRegistration));

        for (int i = 0; i < vehiclesList.size(); i++) {
            var expected = vehiclesList.get(i);
            var resultItem = result.get(i);
            assertEquals(expected.getMake(), resultItem.getMake());
            assertEquals(expected.getModel(), resultItem.getModel());
            assertEquals(expected. getModelYear(), resultItem.getModelYear());
            assertEquals(expected.getRegistration(), resultItem.getRegistration());
        }
    }

    @Test
    void addVehicle() {
        var registration = "LR20DFR";
        var expected = new Vehicle("Land Rover", " Defender", 2020, registration);
        var vehicle = new Vehicle("Land Rover", " Defender",2020, registration);
        var entity = VehicleEntity.fromVehicle(vehicle);
        when(vehicleRepository.save(any(VehicleEntity.class))).thenReturn(entity);

        var result = vehicleService.addVehicle(vehicle);

        assertEquals(expected.getMake(),result.getMake());
        assertEquals(expected.getModel(),result.getModel());
        assertEquals(expected. getModelYear(),result.getModelYear());
        assertEquals(expected.getRegistration(),result.getRegistration());
    }

    @Test
    void updateVehicle_whenTheVehicleExistsInDb() {
        var registration = "LR20DFR";
        var expected = new Vehicle("Land Rover", " Defender", 2020, registration);
        var vehicle = new Vehicle("Land Rover", " Defender",2020, registration);
        var entity = new VehicleEntity((long) 1,registration,"Land Rover"," Defender",2020);

        when(vehicleRepository.getVehicleByRegistration(entity.getRegistration())).thenReturn(entity);
        when(vehicleRepository.save(any(VehicleEntity.class))).thenReturn(entity);

        var optionalResult = vehicleService.updateVehicle(vehicle);

        verify(vehicleRepository).save(any(VehicleEntity.class));

        assertTrue(optionalResult.isPresent());
        var result = optionalResult.get();
        assertEquals(expected.getMake(),result.getMake());
        assertEquals(expected.getModel(),result.getModel());
        assertEquals(expected. getModelYear(),result.getModelYear());
        assertEquals(expected.getRegistration(),result.getRegistration());
    }

    @Test
    void updateVehicle_whenTheVehicleDoesNotExistInDb() {
        var registration = "LR20DFR";
        var expected = new Vehicle("Land Rover", " Defender", 2020, registration);
        var vehicle = new Vehicle("Land Rover", " Defender",2020, registration);
        var entity = new VehicleEntity((long) 1,registration,"Land Rover"," Defender",2020);
        when(vehicleRepository.getVehicleByRegistration(entity.getRegistration())).thenReturn(null);

        var result = vehicleService.updateVehicle(vehicle);
        assertFalse(result.isPresent());
    }

    private List<Vehicle> buildVehiclesList() {
        return Arrays.asList(
                new Vehicle("Land Rover", " Defender", 2020, "LR20DFR"),
                new Vehicle("Jaguar", " XF", 2020, "JA20GXF"),
                new Vehicle("Land Rover", " Discovery", 2020, "LR20DSC")
        );
    }

    private List<VehicleEntity> buildVehicleEntityList() {
        return Arrays.asList(
                new VehicleEntity((long) 1,"LR20DFR","Land Rover"," Defender",2020),
                new VehicleEntity((long) 2, "JA20GXF","Jaguar"," XF",2020),
                new VehicleEntity((long) 3,"LR20DSC", "Land Rover"," Discovery",2020)
        );
    }
}