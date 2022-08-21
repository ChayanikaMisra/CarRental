package com.vehiclerental.service;

import com.vehiclerental.model.Vehicle;
import com.vehiclerental.model.VehicleType;

public class PricingService {
    public static int getPrice(Vehicle vehicle, boolean dynamicPriceEnabled, int startTime, int endTime) {
        int lowestPrice = vehicle.getPrice() * (endTime - startTime);
        if(dynamicPriceEnabled) {
            return (int) (lowestPrice + 0.10 * lowestPrice);
        }
        return lowestPrice;
    }
}
