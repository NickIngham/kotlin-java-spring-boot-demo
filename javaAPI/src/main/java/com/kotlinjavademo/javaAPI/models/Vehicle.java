package com.kotlinjavademo.javaAPI.models;

// The Lombok dependency brings it closer to kotlin with the following annotations
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Vehicle {
    private String make;
    private String model;
    private int modelYear;
    private String registration ;

    public Vehicle(String make, String model, int modelYear, String registration) {
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        this.registration = registration;
    }

    public Vehicle() {
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

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
