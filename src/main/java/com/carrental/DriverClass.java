package com.carrental;


import com.carrental.model.Branch;
import com.carrental.service.RentalService;
import com.carrental.model.Vehicle;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DriverClass {

    public static void main(String[] args) {
        RentalService rentalService = new RentalService(new ArrayList<>());
        rentalService.addBranch("Vasanth Vihar");
        List<Branch> branches = rentalService.addBranch("Cyber City");
        for (Branch b : branches) {
            System.out.println(b.getName() + " " + b.getVehicleTypesPrice());
        }
        System.out.println("\n\n");
        rentalService.allocatePrice("Vasanth Vihar", Vehicle.VehicleType.Sedan, 100);
        rentalService.allocatePrice("Vasanth Vihar", Vehicle.VehicleType.Hatchback, 80);
        rentalService.allocatePrice("Cyber City", Vehicle.VehicleType.Sedan, 200);
        rentalService.allocatePrice("Cyber City", Vehicle.VehicleType.Hatchback, 50);
        for (Branch b : branches) {
            System.out.println(b.getName() + " " + b.getVehicleTypesPrice());
        }
        System.out.println("\n\n");

        rentalService.addVehicle("DL 01 MR 9310", Vehicle.VehicleType.Sedan, "Vasanth Vihar");
        rentalService.addVehicle("DL 01 MR 9311", Vehicle.VehicleType.Sedan, "Cyber City");
        rentalService.addVehicle("DL 01 MR 9312", Vehicle.VehicleType.Hatchback, "Cyber City");

        System.out.println("\n\n");

        String bookingStartTime = "29-02-2020 10:00";
        String bookingEndTime = "29-02-2020 01:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime bookingStartDT = LocalDateTime.parse(bookingStartTime, formatter);
        LocalDateTime bookingEndDT = LocalDateTime.parse(bookingEndTime, formatter);

        rentalService.bookVehicle(Vehicle.VehicleType.Sedan, bookingStartDT, bookingEndDT);
        System.out.println("\n\n");

        rentalService.viewVehicleInventory();


    }
}
