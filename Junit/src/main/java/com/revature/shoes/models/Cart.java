package com.revature.shoes.models;

public class Cart {
    private int id;
    private int shoe_id;
    private int user_id;
    private int inventory_id;

    public Cart() {

    }

    public Cart(int id, int shoe_id, int user_id, int inventory_id) {
        this.id = id;
        this.shoe_id = shoe_id;
        this.user_id = user_id;
        this.inventory_id = inventory_id;
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

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", shoe_id=" + shoe_id +
                ", user_id=" + user_id +
                ", inventory_id=" + inventory_id;
    }
}
