package com.vehiclerental.service;


import com.vehiclerental.model.City;
import com.vehiclerental.model.Vehicle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class VehicleServiceTest {

    @Test
    public void whenBranchDoesnotExistForAddVehicle_thenReturnFalseTest() {
        City c = new City();
        assertEquals(VehicleService.addVehicle(c, "B1", "CAR", "V1", 100), false);
    }

    @Test
    public void whenVehicleTypeDoesnotExistForAddVehicle_thenReturnFalseTest() {
        City c = new City();
        BranchService.addBranch(c, "B1", List.of("VAN", "BIKE"));
        assertEquals(VehicleService.addVehicle(c, "B1", "CAR", "V1", 100), false);
    }

    @Test
    public void whenBranchAndVehicleTypeExistForAddVehicle_thenReturnTrueTest() {
        City c = new City();
        BranchService.addBranch(c, "B1", List.of("CAR", "BIKE"));
        assertEquals(VehicleService.addVehicle(c, "B1", "CAR", "V1", 100), true);
    }

    @Test
    public void sortVehiclesAccToPriceTest() {
        Vehicle vehicle1 = Vehicle.builder()
                .id("V1")
                .price(1000)
                .build();
        Vehicle vehicle2 = Vehicle.builder()
                .id("V2")
                .price(500)
                .build();
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        List<Vehicle> sortedVehicles = VehicleService.sortVehicleAccToPrice(vehicles);
        vehicles.sort((v1, v2) -> {
            if (v1.getPrice() >= v2.getPrice()) {
                return 0;
            }
            return -1;
        });
        assertEquals(sortedVehicles, vehicles);
    }

    @Test
    public void getLowestPriceVehicleTest() {
        Vehicle vehicle1 = Vehicle.builder()
                .id("V1")
                .price(1000)
                .build();
        Vehicle vehicle2 = Vehicle.builder()
                .id("V2")
                .price(500)
                .build();
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        assertEquals(VehicleService.getLowestPricedVehicle(vehicles), vehicle2);
    }
}
