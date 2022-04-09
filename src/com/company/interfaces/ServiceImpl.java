package com.company.interfaces;

import com.company.model.Driver;

import java.util.HashMap;
import java.util.Map;

public interface ServiceImpl {
    Map<Integer, Driver> mapDriver = new HashMap<>();
    default Map<Integer, Driver> poiskId(int id) {
        Map<Integer, Driver> map = new HashMap<>();
        for (Map.Entry<Integer, Driver> entry : mapDriver.entrySet()) {
            if (entry.getKey()==id){
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }
}
