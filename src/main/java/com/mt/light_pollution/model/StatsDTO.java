package com.mt.light_pollution.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class StatsDTO {
    Map<String,Integer> allMap;
    Map<String,Integer> fixedMap;

    public StatsDTO(){
        allMap = new HashMap<>();
        fixedMap = new HashMap<>();
    }
}
