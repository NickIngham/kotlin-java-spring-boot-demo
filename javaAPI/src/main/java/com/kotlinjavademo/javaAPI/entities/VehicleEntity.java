package com.kotlinjavademo.javaAPI.entities;

import com.kotlinjavademo.javaAPI.models.Vehicle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// The Lombok dependency brings it closer to kotlin with the following annotations
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String registration;
    private String make;
    private String model;
    private int modelYear;

    public VehicleEntity(Long id, String registration, String make, String model, int modelYear) {
        this.id = id;
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
    }

    public VehicleEntity(String registration, String make, String model, int modelYear) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
    }

    public VehicleEntity() {
    }

    public Vehicle toDto(){
        return new Vehicle(
                make,
                model,
                modelYear,
                registration
        );
    }

    public static VehicleEntity fromVehicle(Vehicle vehicle){
        return new VehicleEntity(
                vehicle.getRegistration(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getModelYear()
        );
    }

    public static VehicleEntity fromVehicle(Vehicle vehicle, VehicleEntity defaultVehicle){
        return new VehicleEntity(
                vehicle.getRegistration() != null ? vehicle.getRegistration() : defaultVehicle.getRegistration(),
                vehicle.getMake() != null ? vehicle.getMake() : defaultVehicle.getMake(),
                vehicle.getModel() != null ? vehicle.getModel() : defaultVehicle.getModel(),
                vehicle.getModelYear()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
}
