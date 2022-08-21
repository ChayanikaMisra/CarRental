package com.vehiclerental;


import com.vehiclerental.model.City;
import com.vehiclerental.service.BookingService;
import com.vehiclerental.service.BranchService;
import com.vehiclerental.service.VehicleService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DriverClass {

    public static void main(String[] args) throws FileNotFoundException {
    City city = new City();

    File file = new File("/Users/300073365/Documents/personal proj/CarRental/src/main/java/com/vehiclerental/TestCases.txt");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()) {
        String lines = sc.nextLine();
        String[] inputValues = lines.split(" ");
        String command = inputValues[0];
        String branchName = inputValues[1];
        switch (command) {
            case "ADD_BRANCH":
                List<String> vehicleTypes = List.of(inputValues[2].split(","));
                System.out.println(BranchService.addBranch(city, branchName, vehicleTypes));
                break;

            case "ADD_VEHICLE":
                String vehicleType = inputValues[2];
                String vehicleId = inputValues[3];
                int vehiclePrice = Integer.parseInt(inputValues[4]);
                System.out.println(VehicleService.addVehicle(city, branchName, vehicleType, vehicleId, vehiclePrice));
                break;

            case "BOOK":
                String bookingVehicleType = inputValues[2];
                int startTime = Integer.parseInt(inputValues[3]);
                int endTime = Integer.parseInt(inputValues[4]);
                System.out.println(BookingService.bookVehicle(city, branchName, bookingVehicleType, startTime, endTime));
                break;

            case "DISPLAY_VEHICLES":
                int start = Integer.parseInt(inputValues[2]);
                int end = Integer.parseInt(inputValues[3]);
                BookingService.displayAvailableVehicles(city, branchName, start, end);
                break;

            default:
                System.out.println("Invalid command");

        }
    }



//    List<String> vehicleTypes = new ArrayList<String>(Arrays.asList("CAR", "BIKE", "VAN"));
//        System.out.println(BranchService.addBranch(city, "B1", vehicleTypes));
//
//    System.out.println(VehicleService.addVehicle(city, "B1", "CAR", "V1", 500));
//    System.out.println(VehicleService.addVehicle(city, "B1", "CAR", "V2", 1000));
//    System.out.println(VehicleService.addVehicle(city, "B1", "BIKE", "V3", 250));
//    System.out.println(VehicleService.addVehicle(city, "B1", "BIKE", "V4", 300));
//    System.out.println(VehicleService.addVehicle(city, "B1", "BUS", "V5", 2500));
//
//    System.out.println(BookingService.bookVehicle(city, "B1", "VAN", 1, 5));
//    System.out.println(BookingService.bookVehicle(city, "B1", "CAR", 1, 3));
//    System.out.println(BookingService.bookVehicle(city, "B1", "BIKE", 2, 3));
//    System.out.println(BookingService.bookVehicle(city, "B1", "BIKE", 2, 5));
//
//    BookingService.displayAvailableVehicles(city, "B1", 1, 5);
    }
}
