package com.revature.shoes.daos;

import com.revature.shoes.connection.DatabaseConnection;
import com.revature.shoes.models.Location;
import com.revature.shoes.models.Shoe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements CrudDAO<Location> {
    Connection con =  DatabaseConnection.getCon();

    @Override
    public void save(Location obj) {
        try{
            PreparedStatement ps = con.prepareStatement("Insert into locations (location, shoe_name," +
                    " inventory_qty) VALUES (?,?,?)");


            ps.setString(1, obj.getLocation());
            ps.setString(2, obj.getShoe_name());
            ps.setInt(3, obj.getInventory_qty());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Location> findAll() {
        List<Location> locationList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (id) FROM locations");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Location location = new Location();
                location.setId(rs.getInt("id"));
                location.setLocation(rs.getString("location"));
                location.setShoe_name(rs.getString("shoe_name"));
                location.setInventory_qty(rs.getInt("inventory_qty"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return locationList;
    }

    @Override
    public Location findByID(int id) {
        return null;
    }

    @Override
    public Shoe findByID(String id) {
        return null;
    }

    @Override
    public boolean update(Location updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    @Override
    public boolean removeByID(int id) {
        return false;
    }




}
