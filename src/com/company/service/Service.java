package com.company.service;

import com.company.enums.State;
import com.company.model.Driver;
import com.company.model.Truck;
import com.company.model.daoModel.DaoDriver;
import com.company.model.daoModel.DaoTruct;

import java.util.Map;
import java.util.Scanner;

public class Service {
    private DaoDriver daoDriver;
    private DaoTruct daoTruct;

    Scanner scanner = new Scanner(System.in);

    public Service(DaoDriver daoDriver, DaoTruct daoTruct) {
        this.daoDriver = daoDriver;
        this.daoTruct = daoTruct;
    }

    public void changeDriver(int truck) {
        for (Map.Entry<Integer, Truck> e : daoTruct.getMapTruck().entrySet()) {
            if (e.getValue().getState().equals(State.BASE)) {
                daoDriver.show();
                System.out.print("TO CHANGE DRIVER SELECT DRIVER: ");
                int driver = scanner.nextInt();
                poiskTruck(truck, driver);
                break;
            } else if (e.getValue().getState().equals(State.ROUTE)) {
                System.err.printf("YOU CAN'T CHANGE DRIVER, BECAUSE THE TRUCK[%S] ON THE ROUTE\n",
                        e.getValue().getName());
                break;
            } else {
                System.err.printf("YOU CAN'T CHANGE DRIVER, BECAUSE THE TRUCK[%S] ON THE REPAIR\n",
                        e.getValue().getName());
                break;
            }
        }
    }

    public void poiskTruck(int idTruck, int idDriver) {
        Map<Integer, Truck> driverSetTruck = daoTruct.poiskId(idTruck);
        Map<Integer, Driver> truckSetDriver = daoDriver.poiskId(idDriver);
        for (Map.Entry<Integer, Truck> e : driverSetTruck.entrySet()) {
            daoDriver.putTruck(idDriver, e.getValue());
            for (Map.Entry<Integer, Driver> s : truckSetDriver.entrySet()) {
                daoTruct.putDriver(idTruck, s.getValue());
                System.out.println("=================================================");
                System.out.println("Driver changed successfully");
                System.out.println();
            }
        }
    }

    public void showService() {
        System.out.println();
        daoTruct.show();
        System.out.println();
        daoDriver.show();
        System.out.println();
    }

    public void showIdTruck(int id) {
        daoTruct.showId(id);
    }
}
