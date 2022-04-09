package com.company.service;

import com.company.model.Driver;
import com.company.model.Truck;
import com.company.model.daoModel.DaoDriver;
import com.company.model.daoModel.DaoTruct;

import java.util.Map;
import java.util.Optional;

public class Service {
    private DaoDriver daoDriver;
    private DaoTruct daoTruct;

    public Service(DaoDriver daoDriver, DaoTruct daoTruct) {
        this.daoDriver = daoDriver;
        this.daoTruct = daoTruct;
    }

    public void poisk(int idTruck, int idDriver) {
        Map<Integer, Driver> truckSetDriver = daoDriver.poiskId(idDriver);
        for (Map.Entry<Integer, Driver> s : truckSetDriver.entrySet()) {
            daoTruct.putDriver(idTruck, s.getValue());
        }

        Map<Integer, Truck> driverSetTruck = daoTruct.poiskId(idTruck);
        for (Map.Entry<Integer, Truck> e : driverSetTruck.entrySet()) {
            daoDriver.putTruck(idDriver, e.getValue());
        }
    }

    public void showService() {
        daoTruct.show();
        System.out.println();
        daoDriver.show();
    }

    public void showTruck(int id) {
        daoTruct.showId(id);
    }
}
