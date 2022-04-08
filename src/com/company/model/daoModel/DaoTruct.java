package com.company.model.daoModel;

import com.company.enums.State;
import com.company.model.Driver;
import com.company.model.Truck;

import java.util.HashMap;
import java.util.Map;

public class DaoTruct {
    Map<Integer, Truck> mapTruck = new HashMap<>();

    public Map<Integer, Truck> getMapTruck() {
        return mapTruck;
    }

    public void setMapTruck(Map<Integer, Truck> mapTruck) {
        this.mapTruck = mapTruck;
    }

    public String  put(Truck truck) {
        mapTruck.put(truck.getId(), truck);
        return String.valueOf(mapTruck);
    }

    public void putDriver(int id, Driver driver) {
        mapTruck.entrySet().stream().filter(x -> x.getKey() == id).forEach(x -> x.getValue().setDriver(driver));
    }

    public void show() {
        System.out.println("""
                 #     | Bus            | Driver   | State
                -------+----------------+----------+--------------""");
        mapTruck.forEach((key, value) -> System.out.printf("""
                -%d-    |  %s       | %s       | %s            """, key, value.getName(),
                value.getDriver().getName(), value.getState() + "\n"));
    }
}
