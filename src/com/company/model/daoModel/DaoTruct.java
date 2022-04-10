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

    public void put(Truck truck) {
        mapTruck.put(truck.getId(), truck);
    }

    public void putDriver(int id, Driver driver) {
        if (driver.isFree()) {
            for (Map.Entry<Integer, Truck> d : mapTruck.entrySet()) {
                if (d.getKey() == id) {
                    d.getValue().setDriver(driver);
                }
            }
        } else {
            System.out.println("Driver is not free!!");
        }
    }

    public Truck poiskId(int id) {
        return mapTruck.get(id);
    }

    public void route(int id) {
        for (Map.Entry<Integer, Truck> t : mapTruck.entrySet()) {
            if (t.getKey() == id) {
                if (t.getValue().getState().equals(State.ROUTE)) {
                    System.err.println("The truck is on its way");
                } else {
                    if (t.getValue().getDriver() == null) {
                        System.err.println("NO DRIVER");
                    } else {
                        t.getValue().setState(State.ROUTE);
                        System.out.println("=================================================");
                        System.out.println("You have successfully entered the route");
                    }
                }
            }
        }
    }

    public void repairing(int id) {
        mapTruck.entrySet().stream().filter(x -> x.getKey() == id).forEach(x -> x.getValue().setState(State.REPAIR));
        System.out.println("=================================================");
        System.out.println("you have successfully sent for repair");
    }

    public void base(int id) {
        mapTruck.entrySet().stream().filter(x -> x.getKey() == id).forEach(x -> x.getValue().setState(State.BASE));
        System.out.println("=================================================");
        System.out.println("you have successfully sent for base");
    }

    public void showId(int id) {
        for (Map.Entry<Integer, Truck> t : mapTruck.entrySet()) {
            if (id == t.getKey()) {
                try {
                    System.out.println(" Id          : " + t.getValue().getId());
                    System.out.println(" Truck       : " + t.getValue().getName());
                    System.out.println(" Driver      : " + t.getValue().getDriver().getName());
                    System.out.println(" Truck State : " + t.getValue().getState());
                } catch (NullPointerException e) {
                    System.out.println(" Driver      : " + " ");
                    System.out.println(" Truck State : " + t.getValue().getState() + "\n");
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
