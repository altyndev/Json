package com.company.model;

import java.util.Objects;

public class Driver {
    private int id;
    private String name;
    private Truck truck;

    public Driver(int id, String name, Truck truck) {
        this.id = id;
        this.name = name;
        this.truck = truck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }


    public boolean hasTruck() {
        return this.truck != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id && Objects.equals(name, driver.name) && Objects.equals(truck, driver.truck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, truck);
    }

    public boolean isFree() {
        return truck == null;
    }
}
