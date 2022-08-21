package com.vehiclerental.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
public class Vehicle {
    String id;
    int price;
    List<Booking> bookings;
}
