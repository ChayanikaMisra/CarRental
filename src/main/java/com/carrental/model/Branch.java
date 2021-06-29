package com.carrental.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Branch {
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    HashMap<Vehicle.VehicleType, Integer> vehicleTypesPrice;
    List<Vehicle> vehicles;

    public HashMap<Vehicle.VehicleType, Integer> getVehicleTypesPrice() {
        return vehicleTypesPrice;
    }

    public void setVehicleTypesPrice(HashMap<Vehicle.VehicleType, Integer> vehicleTypesPrice) {
        this.vehicleTypesPrice = vehicleTypesPrice;
    }


    String name;


    public Branch(String name) {
        this.name = name;
        this.vehicles=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
