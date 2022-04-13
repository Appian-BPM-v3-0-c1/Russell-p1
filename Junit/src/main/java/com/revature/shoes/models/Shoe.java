package com.revature.shoes.models;

public class Shoe {
    private int id;
    private String brand;
    private String name;
    private String type;
    private int size;
    private String color;
    private int qty;
    private double price;

    public Shoe() {
    }

    public Shoe(int id, String brand, String name, String type, int size, String color, int qty, double price) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.type = type;
        this.size = size;
        this.color = color;
        this.qty = qty;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "" +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", qty=" + qty +
                ", price=" + price;
    }
}
