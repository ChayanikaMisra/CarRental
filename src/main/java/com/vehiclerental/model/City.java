package com.vehiclerental.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class City {
    String name;
    Map<String, Branch> branches = new HashMap<>();
}
