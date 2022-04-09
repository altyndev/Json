package com.company.model.daoModel;

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

    public void put(Truck truck) {
        mapTruck.put(truck.getId(), truck);
    }

    public void putDriver(int id, Driver driver) {
        mapTruck.entrySet().stream().filter(x -> x.getKey() == id).forEach(x -> x.getValue().setDriver(driver));
    }

    public Map<Integer, Truck> poiskId(int id) {
        Map<Integer, Truck> map = new HashMap<>();
        for (Map.Entry<Integer, Truck> entry : mapTruck.entrySet()) {
            if (entry.getKey()==id){
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    public void showId(int id) {
        for (Map.Entry<Integer, Truck> t : mapTruck.entrySet()) {
            if (id == t.getKey()) {
                try {
                    System.out.println(" Id         : " + t.getValue().getId());
                    System.out.println(" Truck      : " + t.getValue().getName());
                    System.out.println(" Driver     : " + t.getValue().getDriver().getName());
                    System.out.println(" Truck State: " + t.getValue().getState());
                } catch (NullPointerException e) {
                    System.out.println("Driver      : " + " ");
                    System.out.println("Truck State : " + t.getValue().getState()+"\n");
                }
            }
        }
    }
    public void show() {
        System.out.println("""
                 #     | Bus            | Driver   | State
                -------+----------------+----------+--------------""");
        for (Map.Entry<Integer, Truck> entry : mapTruck.entrySet()) {
            Integer key = entry.getKey();
            Truck value = entry.getValue();
            try {
                System.out.printf("""
                                -%d-    |  %s       | %s  | %s            """, key, value.getName(),
                        value.getDriver().getName(), value.getState() + "\n");
            } catch (NullPointerException e) {
                System.out.printf("""
                                -%d-    |  %s       | %s        | %s            """, key, value.getName(),
                        " ", value.getState() + "\n");
            }
        }
    }
}
