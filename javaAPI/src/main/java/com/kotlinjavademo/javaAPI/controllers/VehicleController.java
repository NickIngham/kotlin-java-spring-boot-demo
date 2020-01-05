package com.kotlinjavademo.javaAPI.controllers;

import com.kotlinjavademo.javaAPI.models.Vehicle;
import com.kotlinjavademo.javaAPI.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.retrieveAllVehicles();
    }
    @GetMapping("/{registration}")
    public Vehicle getVehicleByRegistration(@PathVariable String registration) {
        var vehicle = vehicleService.getVehicleByRegistration(registration);
        return vehicle.isPresent() ? vehicle.get() : null;
    }

    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @PostMapping("/update")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        var updatedVehicle = vehicleService.updateVehicle(vehicle);
        return updatedVehicle.isPresent() ? updatedVehicle.get() : null;
    }
}
