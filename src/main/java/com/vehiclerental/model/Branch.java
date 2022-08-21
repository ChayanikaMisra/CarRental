package com.vehiclerental.model;


import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Builder
public class Branch {
    String branchName;
    Map<String, VehicleType> vehicleTypes;

}
