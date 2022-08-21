package com.vehiclerental.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Builder
@Setter
@Getter
public class VehicleType {
    String type;
    List<Vehicle> vehicles;

}
