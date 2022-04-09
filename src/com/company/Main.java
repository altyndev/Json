package com.company;

import com.company.enums.State;
import com.company.model.Driver;
import com.company.model.Truck;
import com.company.model.daoModel.DaoDriver;
import com.company.model.daoModel.DaoTruct;
import com.company.service.Service;
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
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Truck truck1 = new Truck(1, "Volvo  ",null, State.BASE);
        Truck truck2 = new Truck(2, "Belarus", null, State.BASE);
        Truck truck3 = new Truck(3, "Russia ", null, State.BASE);

        Driver driver1 = new Driver(1, "Ulan   ");
        Driver driver2 = new Driver(2, "Nurgazy");
        Driver driver3 = new Driver(3, "Almaz  ");

        DaoTruct daoTruct = new DaoTruct();
        daoTruct.put(truck1);
        daoTruct.put(truck2);
        daoTruct.put(truck3);

        DaoDriver daoDriver = new DaoDriver();
        daoDriver.put(driver1);
        daoDriver.put(driver2);
        daoDriver.put(driver3);

        Service service = new Service(daoDriver, daoTruct);
        daoTruct.show();
        do {
            System.out.println();
            System.out.print("ENTER ID OF TRUCK TO SEE ALL INFORMATION ABOUT IT: ");
            int truck = scanner.nextInt();
            daoTruct.showId(truck);
            daoDriver.show();
            int driver = scanner.nextInt();
            service.poisk(truck, driver);


            String json = GSON.toJson(daoTruct);
            write(json);

            String json1 = GSON.toJson(daoDriver);
            writeDrivers(json1);
            service.showService();
        }while (true);
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
