package com.company.model;

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
    public String
    toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", truck=" + truck +
                '}';
    }
}
