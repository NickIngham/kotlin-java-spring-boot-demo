package com.kotlinjavademo.javaAPI.services;

import com.kotlinjavademo.javaAPI.entities.VehicleEntity;
import com.kotlinjavademo.javaAPI.models.Vehicle;
import com.kotlinjavademo.javaAPI.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Optional<Vehicle> getVehicleByRegistration(String registration) {
        var vehicleEntity = vehicleRepository.getVehicleByRegistration(registration);
        return vehicleEntity != null ? Optional.of(vehicleEntity.toDto()) : Optional.empty();
    }

    public List<Vehicle> retrieveAllVehicles(){
        return vehicleRepository.findAll().stream().map(VehicleEntity::toDto).collect(Collectors.toList());
    }

    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepository.save(VehicleEntity.fromVehicle(vehicle)).toDto();
    }

    public Optional<Vehicle> updateVehicle(Vehicle vehicle){
        var currentVehicle = vehicleRepository.getVehicleByRegistration(vehicle.getRegistration());
        return currentVehicle != null ?
                Optional.of(vehicleRepository.save(VehicleEntity.fromVehicle(vehicle, currentVehicle)).toDto())
                :Optional.empty();
    }
}
