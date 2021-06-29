package com.carrental.service;


import com.carrental.model.Branch;
import com.carrental.model.Vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RentalService {
    List<Branch> branches;
    String city;

    public RentalService(List<Branch> branches) {
        this.branches = branches;
    }

    public List<Branch> addBranch(String name) {
        Branch newBranch = new Branch(name);
        HashMap<Vehicle.VehicleType,Integer> vehicleTypesPrice = new HashMap<>();
        vehicleTypesPrice.put(Vehicle.VehicleType.Sedan,0);
        vehicleTypesPrice.put(Vehicle.VehicleType.Hatchback,0);
        vehicleTypesPrice.put(Vehicle.VehicleType.SUV,0);
        newBranch.setVehicleTypesPrice(vehicleTypesPrice);
        this.branches.add(newBranch);
        System.out.println("Branch added successfully");
        return this.branches;
    }

    public void allocatePrice(String branchName, Vehicle.VehicleType vehicleType, int price) {
        for (Branch b : this.branches) {
            if (b.getName().equals(branchName)) {
                HashMap<Vehicle.VehicleType, Integer> hm=b.getVehicleTypesPrice();
                hm.put(vehicleType,price);
            }
        }
    }

    public void addVehicle(String vehicleId, Vehicle.VehicleType vehicleType, String branchName){

        for(Branch b : this.branches) {
            if (b.getName().equals(branchName)) {
                List<Vehicle> vehicles=b.getVehicles();
                Vehicle newVehicle=new Vehicle(vehicleId, vehicleType, "available");
                vehicles.add(newVehicle);
                System.out.println("Vehicle added:   "+vehicleId);

            }
        }

    }

    public void bookVehicle(Vehicle.VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime){
        int minPrice=Integer.MAX_VALUE;
        Branch minBranch=this.branches.get(0);
        for(Branch b : this.branches) {
            HashMap<Vehicle.VehicleType,Integer> vehicleTypesPrice=b.getVehicleTypesPrice();
            for(Map.Entry<Vehicle.VehicleType, Integer> vehicleTypePrice : vehicleTypesPrice.entrySet())
            {
                if(vehicleTypePrice.getKey()==vehicleType)
                {
                    if(vehicleTypePrice.getValue()<minPrice)
                    {
                        minPrice=vehicleTypePrice.getValue();
                        minBranch=b;

                    }
                }
            }
            List<Vehicle> vehicles=minBranch.getVehicles();
            for(Vehicle v:vehicles)
            {
                if(v.getVehicleType()==vehicleType )
                {
                    System.out.println("Vehicle booked:  "+v.getId());
                    v.setStatus("Unavailable");
                    return;
                }
            }
        }

    }

    public void viewVehicleInventory(){
        for(Branch b : this.branches) {
            System.out.println(b.getName());
            List<Vehicle> vehicles=b.getVehicles();
            for(Vehicle v:vehicles)
                System.out.println(v.getId()+" "+v.getStatus());
            System.out.println("\n");
        }

    }




}

