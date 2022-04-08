package com.company;

import com.company.enums.State;
import com.company.model.Driver;
import com.company.model.Truck;
import com.company.model.daoModel.DaoDriver;
import com.company.model.daoModel.DaoTruct;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Path PATH = Paths.get("./truck.json");
    public static final Path PATH1 = Paths.get("./driver.json");

    public static void main(String[] args) {
        Driver driver = new Driver(1, "Ulan   ");
        Truck truck = new Truck(1, "Volvo  ",driver, State.BASE);
        Truck truck1 = new Truck(2, "Belarus",null, State.BASE);
        Truck truck2 = new Truck(3, "Russia ",null, State.BASE);

        DaoTruct daoTruct = new DaoTruct();
//        daoTruct.setMapTruck((Map<Integer, Truck>) truck);
//        daoTruct.setMapTruck((Map<Integer, Truck>) truck1);
//        daoTruct.setMapTruck((Map<Integer, Truck>) truck2);
        daoTruct.put(truck);
        daoTruct.put(truck1);
        daoTruct.put(truck2);
        String json = GSON.toJson(daoTruct);
        write(json);

        Driver driver1 = new Driver(2, "Nurgazy");
        Driver driver2 = new Driver(3, "Almaz  ");

//        driver.setTruck(truck);
//        driver1.setTruck(truck1);
//        driver2.setTruck(truck2);

        DaoDriver daoDriver = new DaoDriver();
        daoDriver.put(driver);
        daoDriver.put(driver1);
        daoDriver.put(driver2);



        String json1 = GSON.toJson(daoDriver);
        writeDrivers(json1);

        daoTruct.putDriver( 1, driver);
        daoTruct.putDriver( 3, driver1);
        daoTruct.putDriver( 2, driver2);
        daoTruct.show();
        System.out.println();
        daoDriver.show();

    }
    public static void write(String o) {
        try {
            Path path = Paths.get(String.valueOf(PATH));
            Files.writeString(path, o, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDrivers(String o) {
        try {
            Path path = Paths.get(String.valueOf(PATH1));
            Files.writeString(path, o, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
