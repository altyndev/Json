package com.company.model;

import com.company.enums.State;

import java.util.Objects;

public class Truck {
    private int id;
    private String name;
    private Driver driver;
    private State state;

    public Truck(int id, String name, Driver driver, State state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return id == truck.id && Objects.equals(name, truck.name) && Objects.equals(driver, truck.driver) && state == truck.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, driver, state);
    }

    public boolean hasDriver() {
        return this.driver != null;
    }
}