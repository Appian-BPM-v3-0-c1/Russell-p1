package com.revature.shoes.models;

public class History {
    private int id;
    private int shoe_id;
    private int user_id;
    private int cart_id;
    private String location;

    public History() {
    }

    public History(int id, int shoe_id, int user_id, int cart_id, String location) {
        this.id = id;
        this.shoe_id = shoe_id;
        this.user_id = user_id;
        this.cart_id = cart_id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShoe_id() {
        return shoe_id;
    }

    public void setShoe_id(int shoe_id) {
        this.shoe_id = shoe_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", shoe_id=" + shoe_id +
                ", user_id=" + user_id +
                ", cart_id=" + cart_id +
                ", location='" + location;
    }
}
