package com.company.model.daoModel;

import com.company.model.Driver;
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

    public void show() {
        System.out.println("""
                 #     | Driver         | Bus      
                -------+----------------+--------------""");
        mapDriver.forEach((key, values) -> System.out.printf("""
                -%d-    | %s        | %s           """,
        key, values.getName(), values.getTruck() + "\n"));

    }
}
