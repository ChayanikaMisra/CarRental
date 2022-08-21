package com.vehiclerental.service;

import com.vehiclerental.model.Branch;
import com.vehiclerental.model.City;
import com.vehiclerental.model.VehicleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BranchService {
    public static boolean checkBranchExists(City c, String branchName) {
        Map<String, Branch> allBranches = c.getBranches();
        return allBranches.containsKey(branchName);
    }

    public static Boolean addBranch(City c, String branchName, List<String> vehicleNames) {
        if(BranchService.checkBranchExists(c, branchName)) {
            return false;
        }
        Map<String, Branch> allBranches = c.getBranches();
        Map<String, VehicleType> vehicleTypes = new HashMap<>();
        for(String vehicleName: vehicleNames) {
            VehicleType vehicleType = VehicleType.builder()
                    .type(vehicleName)
                    .build();
            vehicleTypes.put(vehicleName, vehicleType);
        }
        Branch newBranch = Branch.builder()
                .branchName(branchName)
                .vehicleTypes(vehicleTypes)
                .build();

        allBranches.put(branchName, newBranch);
        return true;
    }

    public static Branch getBranch(City c, String branchName) {
        if(!checkBranchExists(c, branchName)) {
            return null;
        }
        Map<String, Branch> allBranches = c.getBranches();
        return allBranches.get(branchName);
    }

    public static Boolean checkVehicleTypeExists(Branch branch, String vehicleType) {
        Map<String, VehicleType> vehicleTypeMap = branch.getVehicleTypes();
        return vehicleTypeMap.containsKey(vehicleType);
    }

    public static VehicleType getVehicleType(Branch branch, String vehicleType) {
        if(!checkVehicleTypeExists(branch, vehicleType)) {
            return null;
        }
        Map<String, VehicleType> allVehicleTypes = branch.getVehicleTypes();
        return allVehicleTypes.get(vehicleType);
    }

}
