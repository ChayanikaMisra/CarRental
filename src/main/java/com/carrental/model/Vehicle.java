package com.carrental.model;


public class Vehicle {
    String id;
    VehicleType vehicleType;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static enum VehicleType {
        Sedan,
        Hatchback,
        SUV;

    }

    public Vehicle(String id, VehicleType vehicleType, String status) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.status=status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
