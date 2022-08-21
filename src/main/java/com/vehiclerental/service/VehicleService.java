package com.vehiclerental.service;

import com.vehiclerental.model.Branch;
import com.vehiclerental.model.City;
import com.vehiclerental.model.Vehicle;
import com.vehiclerental.model.VehicleType;

import java.util.*;

public class VehicleService {


    public static Boolean addVehicle(City c, String branchName, String newVehicleType, String id, int price){
        Branch branch = BranchService.getBranch(c, branchName);
        if(branch == null) {
            return false;
        }
        VehicleType vehicleType = BranchService.getVehicleType(branch, newVehicleType);
        if(vehicleType == null) {
            return false;
        }

        List<Vehicle> vehicles = vehicleType.getVehicles();
        if(vehicles == null) {
            vehicles = new ArrayList<>();
        }
        Vehicle newVehicle = Vehicle.builder()
                .id(id)
                .price(price)
                .build();
        vehicles.add(newVehicle);
        vehicleType.setVehicles(vehicles);
        return true;
    }

    public static List<Vehicle> sortVehicleAccToPrice(List<Vehicle> vehicles) {
        vehicles.sort((v1, v2) -> {
            if (v1.getPrice() >= v2.getPrice()) {
                return 0;
            }
            return -1;
        });
        return vehicles;
    }


    public static Vehicle getLowestPricedVehicle(List<Vehicle> vehicles) {
        List<Vehicle> sortedVehicles = sortVehicleAccToPrice(vehicles);
        return sortedVehicles.get(0);
    }
}
