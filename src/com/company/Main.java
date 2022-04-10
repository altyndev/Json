package com.company;

import com.company.dto.DriverDto;
import com.company.dto.DriverWithoutTruck;
import com.company.dto.TruckDto;
import com.company.dto.TruckWithoutDriver;
import com.company.enums.State;
import com.company.exceptions.InvalidChangeAttemptException;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Path PATH = Paths.get("./truck.json");
    public static final Path PATH1 = Paths.get("./driver.json");
    static Scanner scanner = new Scanner(System.in);
    static DaoTruct daoTruct = new DaoTruct();
    static DaoDriver daoDriver = new DaoDriver();
    static Service service = new Service(daoDriver, daoTruct);

    public static void main(String[] args) {

        Truck truck1 = new Truck(1, "Volvo  ", null, State.BASE);
        Truck truck2 = new Truck(2, "Belarus", null, State.BASE);
        Truck truck3 = new Truck(3, "Russia ", null, State.BASE);

        Driver driver1 = new Driver(1, "Ulan   ", null);
        Driver driver2 = new Driver(2, "Nurgazy", null);
        Driver driver3 = new Driver(3, "Almaz  ", null);

        daoTruct.put(truck1);
        daoTruct.put(truck2);
        daoTruct.put(truck3);

        daoDriver.put(driver1);
        daoDriver.put(driver2);
        daoDriver.put(driver3);

        daoTruct.show();

        while (true) {
            try {
                System.out.println();
                System.out.print("ENTER ID OF TRUCK TO SEE ALL INFORMATION ABOUT IT: ");
                int truck = scanner.nextInt();
                service.showIdTruck(truck);
                System.out.println("Press 1 to change Driver");
                System.out.println("Press 2 to send to the Route");
                System.out.println("Press 3 ot send to the Repairing");
                int state = scanner.nextInt();
                switch (state) {
                    case 1 -> service.changeDriver(truck);
                    case 2 -> daoTruct.route(truck);
                    case 3 -> daoTruct.repairing(truck);
                }
            } catch (InvalidChangeAttemptException e) {
                System.err.println("WE COULD NOT FIND THIS NUMBER");
            }
            service.showService();
            System.out.println("=================================================");
            Map<Integer, TruckDto> mapTruck = new HashMap<>();
            Map<Integer, DriverDto> mapDriver = new HashMap<>();

            daoTruct.getMapTruck().forEach((key, value) -> {
                mapTruck.put(key, new TruckDto(value.getId(),
                        value.getName(),
                        value.hasDriver() ? convert(value.getDriver()) : null,
                        value.getState()));
            });

            daoDriver.getMapDriver().forEach((key, value) -> {
                mapDriver.put(key, new DriverDto(value.getId(),
                        value.getName(),
                        value.hasTruck() ? convert(value.getTruck()) : null));
            });
            String json = GSON.toJson(mapTruck);
            write(json);

            String json1 = GSON.toJson(mapDriver);
            writeDrivers(json1);
        }
    }

    private static TruckWithoutDriver convert(Truck truck) {
        return new TruckWithoutDriver(
                truck.getId(),
                truck.getName(),
                truck.getState()
        );
    }

    private static DriverWithoutTruck convert(Driver driver) {
        return new DriverWithoutTruck(driver.getId(), driver.getName());
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
