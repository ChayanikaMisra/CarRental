package com.vehiclerental.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Booking {
    int startTime;
    int endTime;
}
