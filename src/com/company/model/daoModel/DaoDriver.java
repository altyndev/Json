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

    public Driver poiskId(int id) {
       return mapDriver.get(id);
    }

    public void show() {
        System.out.println("""
                 #     | Driver         | Bus      
                -------+----------------+--------------""");
        for (Map.Entry<Integer, Driver> entry : mapDriver.entrySet()) {
            Integer key = entry.getKey();
            Driver value = entry.getValue();
            try {
                System.out.printf("""
                                -%d-    | %s        | %s           """,
                        key, value.getName(), value.getTruck().getName() + "\n");
            } catch (NullPointerException e) {
                System.out.printf("""
                                -%d-    | %s        | %s           """,
                        key, value.getName(), " " + "\n");
            }
        }
    }
}
