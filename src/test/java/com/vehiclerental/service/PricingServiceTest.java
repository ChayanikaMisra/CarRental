package com.vehiclerental.service;

import com.vehiclerental.model.Branch;
import com.vehiclerental.model.City;
import com.vehiclerental.model.Vehicle;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PricingServiceTest {
    @Test
    public void getPrice_dynamicPricingFalseTest() {
        City c = new City();
        Vehicle vehicle = Vehicle.builder()
                .price(120)
                .build();
        int startTime = 1;
        int endTime = 5;
        assertEquals(PricingService.getPrice(vehicle, false, startTime, endTime), 480);
    }

    @Test
    public void getPrice_dynamicPricingTrueTest() {
        City c = new City();
        Vehicle vehicle = Vehicle.builder()
                .price(120)
                .build();
        int startTime = 1;
        int endTime = 5;
        assertEquals(PricingService.getPrice(vehicle, true, startTime, endTime), 528);
    }
}
