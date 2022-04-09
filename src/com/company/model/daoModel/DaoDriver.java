package com.company.model.daoModel;

import com.company.model.Driver;
import com.company.model.Truck;

import java.util.HashMap;
import java.util.Map;

public class DaoDriver {
    Map<Integer, Driver> mapDriver = new HashMap<>();

    public Map<Integer, Driver> getMapDriver() {
        return mapDriver;
    }

    public void setMapDriver(Map<Integer, Driver> mapDriver) {
        this.mapDriver = mapDriver;
    }

    public void put(Driver driver) {
        mapDriver.put(driver.getId(), driver);
    }

    public void putTruck(int id, Truck truck) {
        mapDriver.entrySet().stream().filter(x -> x.getKey() == id).forEach(x -> x.getValue().setTruck(truck));
    }

    public Map<Integer, Driver> poiskId(int id) {
        Map<Integer, Driver> map = new HashMap<>();
        for (Map.Entry<Integer, Driver> entry : mapDriver.entrySet()) {
            if (entry.getKey()==id){
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    public void show() {
        System.out.println("""
                 #     | Driver         | Bus      
                -------+----------------+--------------""");
        mapDriver.forEach((key, values) -> System.out.printf("""
                        -%d-    | %s        | %s           """,
                key, values.getName(), values.getTruck() + "\n"));

    }
}
