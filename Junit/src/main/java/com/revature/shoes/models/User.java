package com.revature.shoes.models;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int zipCode;
    private int shoeSize;
    private String favBrand;
    private String userName;

    public User() {
    }

    public User(int id, String firstName, String lastName, String email, int zipCode, int shoeSize, String favBrand, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.zipCode = zipCode;
        this.shoeSize = shoeSize;
        this.favBrand = favBrand;
        this.userName = userName;
    }

    public int getId(int i) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName(String next) {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(String next) {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail(String next) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public String getFavBrand() {
        return favBrand;
    }

    public void setFavBrand(String favBrand) {
        this.favBrand = favBrand;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
