package com.revature.shoes.models;

public class Location {
    private int id;
    private String location;
    private String shoe_name;
    private int inventory_qty;

    public Location() {
    }

    public Location(int id, String location, String shoe_name, int inventory_qty) {
        this.id = id;
        this.location = location;
        this.shoe_name = shoe_name;
        this.inventory_qty = inventory_qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShoe_name() {
        return shoe_name;
    }

    public void setShoe_name(String shoe_name) {
        this.shoe_name = shoe_name;
    }

    public int getInventory_qty() {
        return inventory_qty;
    }

    public void setInventory_qty(int inventory_qty) {
        this.inventory_qty = inventory_qty;
    }

    @Override
    public String toString() {
        return
                ", location='" + location + '\'' +
                ", shoe_name='" + shoe_name + '\'' +
                ", inventory_qty=" + inventory_qty +
                '}';
    }
}
