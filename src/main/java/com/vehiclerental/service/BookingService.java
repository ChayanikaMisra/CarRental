package com.vehiclerental.service;


import com.vehiclerental.model.*;

import java.time.LocalDateTime;
import java.util.*;


public class BookingService {
    public static int bookVehicle(City c, String branchName, String bookingVehicleType, int startTime, int endTime){
        Branch branch = BranchService.getBranch(c, branchName);
        if(branch == null) {
            return -1;
        }
        VehicleType vehicleType = BranchService.getVehicleType(branch, bookingVehicleType);
        if(vehicleType == null) {
            return -1;
        }
        List<Vehicle> availableVehicles = getAllAvailableVehicles(vehicleType, startTime, endTime);

        if(availableVehicles != null) {
            boolean dynamicPriceEnabled = checkForDynamicPricing(vehicleType, availableVehicles);
            Vehicle lowestPricedAvailableVehicle = VehicleService.getLowestPricedVehicle(availableVehicles);
            createNewBooking(lowestPricedAvailableVehicle, startTime, endTime);
            return PricingService.getPrice(lowestPricedAvailableVehicle, dynamicPriceEnabled, startTime, endTime);
        }
        return -1;
    }

    public static boolean checkForDynamicPricing(VehicleType vehicleType, List<Vehicle> availableVehicles) {
        List<Vehicle> vehicles = vehicleType.getVehicles();
        if (vehicles == null || availableVehicles == null) {
            return false;
        }
        if(vehicles.size() == 0 || availableVehicles.size() == 0) {
            return false;
        }
        if(availableVehicles.size() <= (0.20 * vehicles.size())){
            return true;
        }
        return false;
    }

    public static List<Vehicle> getAllAvailableVehicles(VehicleType vehicleType, int bookingStartTime, int bookingEndTime){
        List<Vehicle> vehicles = vehicleType.getVehicles();
        if (vehicles == null) {
            return null;
        }
        List<Vehicle> availableVehicles = new ArrayList<>();
        for(Vehicle vehicle: vehicles) {
            List<Booking> bookings = vehicle.getBookings();
            if(bookings == null) {
                availableVehicles.add(vehicle);
                continue;
            }
            boolean available = true;
            for(Booking booking: bookings) {
                if(booking.getStartTime() >= bookingStartTime && booking.getEndTime() <= bookingEndTime){
                    available = false;
                }
                if(booking.getStartTime() >= bookingStartTime && booking.getEndTime() >= bookingEndTime){
                    available = false;
                }
                if(booking.getStartTime() <= bookingStartTime && booking.getEndTime() <= bookingEndTime){
                    available = false;
                }
                if(booking.getStartTime() <= bookingStartTime && booking.getEndTime() >= bookingEndTime){
                    available = false;
                }
            }
            if(available) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }


    public static void createNewBooking(Vehicle vehicle, int startTime, int endTime) {
        List<Booking> bookings = vehicle.getBookings();
        if(bookings == null) {
            bookings = new ArrayList<>();
        }
        bookings.add(Booking.builder()
                        .startTime(startTime)
                        .endTime(endTime)
                        .build());
        vehicle.setBookings(bookings);
    }

    public static void displayAvailableVehicles(City c, String branchName, int startTime, int endTime){
        Branch branch = BranchService.getBranch(c, branchName);
        if(branch == null) {
            return;
        }
        Map<String, VehicleType> vehicleTypes = branch.getVehicleTypes();
        for(Map.Entry<String, VehicleType> mp: vehicleTypes.entrySet()){
            VehicleType vehicleType = mp.getValue();
            List<Vehicle> availableVehicles = getAllAvailableVehicles(vehicleType, startTime, endTime);
            if(availableVehicles == null) {
                continue;
            }
            List<Vehicle> sortedVehicles = VehicleService.sortVehicleAccToPrice(availableVehicles);
            for(Vehicle vehicle: sortedVehicles){
                System.out.println(vehicle.getId());
            }
        }

    }




}

