package com.revature.shoes.models;

public class Cart {
    private int cart_id;
    private int shoe_id;
    private int user_id;
    private double total_price;

    public Cart() {

    }

    public Cart(int cart_id, int shoe_id, int user_id, double total_price) {
        this.cart_id = cart_id;
        this.shoe_id = shoe_id;
        this.user_id = user_id;
        this.total_price = total_price;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
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

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", shoe_id=" + shoe_id +
                ", user_id=" + user_id +
                ", total_price=" + total_price +
                '}';
    }
}
